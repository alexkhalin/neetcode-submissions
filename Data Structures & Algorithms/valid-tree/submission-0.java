class Solution {
    private static class UnionFind {

        int size;
        int[] graph;
        public UnionFind(int size) {
            this.size = size;
            graph = new int[size];
            for (int i = 0; i < size; i++) {
                graph[i] = i;
            } 
        }

        public boolean union(int left, int right) {
            int leftParent = find(left);
            int rightParent = find(right);
            if (leftParent == rightParent) return false;
            if (leftParent < rightParent) {
                graph[rightParent] = leftParent; 
            } else {
                graph[leftParent] = rightParent;
            }
            return true;
        }
        
        public int find(int node) {
            if (node == graph[node]) return node;
            int parent = find(graph[node]);
            graph[node] = parent;
            return parent;
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
