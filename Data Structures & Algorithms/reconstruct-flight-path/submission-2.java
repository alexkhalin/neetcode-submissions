class Solution {
    private static class Airport {
        private String name;
        private List<Airport> destinations;
        int idx;
        public Airport(String name) {
            this.name = name;
            destinations = new ArrayList<>();
        }
    }

    private Map<String, Airport> buildGraph(List<List<String>> tickets) {
        Map<String, Airport> graph = new HashMap<>();
        for (var ticket: tickets) {
            Airport from = graph.computeIfAbsent(ticket.get(0), name -> new Airport(name));
            Airport to = graph.computeIfAbsent(ticket.get(1), name -> new Airport(name));
            from.destinations.add(to);
        }
        for (var entry : graph.entrySet()) {
            entry.getValue().destinations.sort((a1, a2) -> a1.name.compareTo(a2.name));
        }

        return graph;
    }
    
    private int dfs(Airport from, String[] path, int idx) {
        
        while (from.idx != from.destinations.size()) {
            Airport to = from.destinations.get(from.idx++);
            idx = dfs(to, path, idx);
        }
        path[idx] = from.name;
        return --idx;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Airport> graph = buildGraph(tickets);
        Airport start = graph.get("JFK");
        String[] path = new String[tickets.size() + 1];
        dfs(start, path, path.length - 1);
        return Arrays.asList(path);
    }
}
