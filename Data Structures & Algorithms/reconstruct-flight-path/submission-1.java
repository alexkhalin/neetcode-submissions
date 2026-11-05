class Solution {
    private static class Airport {
        private String name;
        private List<Airport> destinations;
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
            entry.getValue().destinations.sort((a1, a2) -> a2.name.compareTo(a1.name));
        }

        return graph;
    }
    
    private List<String> dfs(Airport from) {
        
        if (from.destinations.isEmpty()) {
            List<String> res = new LinkedList<>();
            res.add(from.name);
            return res;
        }

        Airport to = from.destinations.get(from.destinations.size() - 1);
        from.destinations.remove(from.destinations.size() - 1);
        List<String> res = dfs(to);
        if (from.destinations.isEmpty()) {
            res.addFirst(from.name);
            return res;
        }
        to = from.destinations.get(from.destinations.size() - 1);
        from.destinations.remove(from.destinations.size() - 1);
        List<String> res2 = dfs(to);
        res2.addFirst(from.name);
        if (!from.destinations.isEmpty()) throw new RuntimeException();
        res2.addAll(res);
        return res2;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Airport> graph = buildGraph(tickets);
        Airport start = graph.get("JFK");
        return dfs(start);
    }
}
