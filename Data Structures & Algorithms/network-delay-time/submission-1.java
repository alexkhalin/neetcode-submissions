class Solution {
    private static List<List<int[]>> buildGraph(int[][] times, int n) {
        List<List<int[]>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge: times) {
            graph.get(edge[0]).add(edge);
        }
        return graph;
    }

    private static int dijkstra(List<List<int[]>> graph, int k) {
        int toVisit = graph.size() - 1;

        PriorityQueue<int[]> heap = new PriorityQueue<>((e1, e2) -> Integer.compare(e1[1], e2[1]));
        heap.add(new int[] {k, 0});
        do {
            int[] currEdge = heap.remove();
            List<int[]> node = graph.get(currEdge[0]);
            if (node == null) continue;
            int time = currEdge[1];
            if (--toVisit == 0) return time;
            for (int[] nextEdge : node) {
                heap.add(new int[] {nextEdge[1], time + nextEdge[2]});
            }
            graph.set(currEdge[0], null);

        } while (!heap.isEmpty());

        return -1;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = buildGraph(times, n);

        return dijkstra(graph, k);
    }
}
