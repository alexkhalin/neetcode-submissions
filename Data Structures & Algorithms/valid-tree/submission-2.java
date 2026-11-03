class Solution {
    private static class UnionFind {

        int[] graph;
        public UnionFind(int size) {
            graph = new int[size];
            for (int i = 0; i < size; i++) {
                graph[i] = i;
            } 
        }

        public boolean union(int left, int right) {
            int leftParent = find(left);
            int rightParent = find(right);
            if (leftParent == rightParent) return false;
            
            graph[rightParent] = leftParent;            
            return true;
        }
        
        public int find(int node) {
            if (node == graph[node]) return node;
            return graph[node] = find(graph[node]);
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return false;
        }
        return true;
    }
}
