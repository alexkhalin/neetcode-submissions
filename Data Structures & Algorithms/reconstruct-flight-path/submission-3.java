class Solution {
    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (var ticket: tickets) {
            graph.computeIfAbsent(ticket.get(0), name -> new PriorityQueue<>()).add(ticket.get(1));
        }

        return graph;
    }
    
    private int dfs(Map<String, PriorityQueue<String>> graph, String from, String[] path, int idx) {
        PriorityQueue<String> destinations = graph.get(from);
        while (destinations != null && !destinations.isEmpty()) {
            String to = destinations.remove();
            idx = dfs(graph, to, path, idx);
        }
        path[idx] = from;
        return --idx;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = buildGraph(tickets);
        String[] path = new String[tickets.size() + 1];
        dfs(graph, "JFK", path, path.length - 1);
        return Arrays.asList(path);
    }
}
