class Solution {
    private static class UnionFind {
        int[] graph;

        public UnionFind(int size) {
            graph = new int[size];
            for (int i = 0; i != size; i++) {
                graph[i] = i;
            }
        }

        public boolean union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);

            if (parent1 == parent2) return false;
            graph[parent1] = parent2;
            return true;
        }

        public int find(int node1) {
            if (node1 == graph[node1]) return node1;
            return graph[node1] = find(graph[node1]);
        }
    }

    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.union(edge[0], edge[1])) n--;
        }

        return n;
    }
}
