class Solution {

    private static class Heap {
        int[] times;
        int[] heap;
        int[] positions;
        int size;

        public Heap(int capacity) {
            times = new int[capacity];
            heap = new int[capacity];
            positions = new int[capacity];
            size = 0;
            Arrays.fill(times, Integer.MAX_VALUE);
        }

        public boolean offer(int dstNode, int time) {            
            if (times[dstNode] <= time) return false;
            if (times[dstNode] == Integer.MAX_VALUE) {
                times[dstNode] = time;
                heap[size] = dstNode;
                positions[dstNode] = size;
                pushUp(size);
                size++;
            } else {
                times[dstNode] = time;
                pushUp(positions[dstNode]);
            }
            return true;
        }

        public int[] poll() {
            int[] res = new int[] {heap[0], times[heap[0]]};
            size--;
            heap[0] = heap[size];
            pushDown(0);
            return res;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        private void pushUp(int childIdx) {
            int childNode = heap[childIdx];
            while (childIdx != 0) {
                int parentIdx = (childIdx - 1) >>> 1;
                if (times[heap[parentIdx]] <= times[childNode]) break;
                positions[heap[parentIdx]] = childIdx;
                heap[childIdx] = heap[parentIdx];
                childIdx = parentIdx;
            }
            heap[childIdx] = childNode;
            positions[childNode] = childIdx;
        }

        private void pushDown(int parentIdx) {
            int parentNode = heap[parentIdx];
            int half = size >>> 1;
            while (parentIdx < half) {
                int childIdx = (parentIdx << 1) + 1;
                int rightIdx = childIdx + 1;
                if (rightIdx < size && times[heap[rightIdx]] < times[heap[childIdx]]) childIdx = rightIdx;
                if (times[parentNode] < times[heap[childIdx]]) break;

                heap[parentIdx] = heap[childIdx];
                positions[heap[parentIdx]] = parentIdx;
                parentIdx = childIdx;
            }
            heap[parentIdx] = parentNode;
            positions[parentNode] = parentIdx;
        }
    }

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

        Heap heap = new Heap(graph.size());
        heap.offer(k, 0);
        do {
            int[] currEdge = heap.poll();
            List<int[]> node = graph.get(currEdge[0]);
            if (node == null) continue;
            int time = currEdge[1];
            if (--toVisit == 0) return time;
            for (int[] nextEdge : node) {
                heap.offer(nextEdge[1], time + nextEdge[2]);
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
