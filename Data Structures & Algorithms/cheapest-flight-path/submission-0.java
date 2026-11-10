class Solution {
    private static class PathNode {
        int airport;
        int cost;
        int stops;

        PathNode(int airport, int cost, int stops) {
            this.airport = airport;
            this.cost = cost;
            this.stops = stops;
        }

        @Override
        public int hashCode() { return airport;}
        @Override
        public boolean equals(Object other) { return this.airport == ((PathNode)other).airport;}
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] f : flights) {
            graph[f[0]].add(f);
        }

        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        PriorityQueue<PathNode> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.add(new PathNode(src, 0, -1));
        while (!pq.isEmpty()) {
            PathNode node = pq.remove();
            if (node.airport == dst && node.stops <= k) return node.cost;
            if (visited[node.airport] <= node.stops) continue;
            visited[node.airport] = node.stops;
            int nextStops = node.stops + 1;
            for (int[] next : graph[node.airport]) {
                if (nextStops < visited[next[1]] && nextStops <= k) {
                    pq.add(new PathNode(next[1], node.cost + next[2], nextStops));
                }
            }
        }

        return -1;
    }
}
