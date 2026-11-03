class Solution {

    private static class UnionFind {
        int parent[];
        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i != size; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int node1, int node2) {
            int parent1 = find(node1);
            int parent2 = find(node2);
            if (parent1 == parent2) return false;

            parent[parent1] = parent2;
            return true;
        }

        public int find(int node) {
            if (node == parent[node]) return node;
            return parent[node] = find(parent[node]);
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);

        for(int[] edge: edges) {
            if (!uf.union(edge[0] - 1, edge[1] - 1)) return edge;
        }
        return new int[] {};
    }
}
