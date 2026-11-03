class Solution {
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
        }
        return graph;
    }
    
    private int dfs(List<Integer>[] graph, int fromNode, int[] order, int fromOrder) {
        if (order[fromNode] > -1) {
            return 0;
        }
        if (order[fromNode] == -2) return -2;
        order[fromNode] = -2;
        int total = 0;
        for (Integer toNode : graph[fromNode]) {
            int found = dfs(graph, toNode, order, fromOrder - total);
            if (found == -2) return -2;
            total += found;
        }
        total++;
        order[fromNode] = fromOrder - total;
        return total;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        int[] order = new int[numCourses];
        Arrays.fill(order, -1);
        int total = 0;
        for (int i = 0; i < numCourses; i++) {
            int found = dfs(graph, i, order, numCourses - total);
            if (found == -2) return new int[]{};
            total += found;
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[order[i]] = i;
        } 
        return res;
    }
}
