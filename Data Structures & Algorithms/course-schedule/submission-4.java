class Solution {

    private boolean dfs(List<Integer>[] graph, int from, BitSet globalVisited, BitSet localVisited) {
        if (localVisited.get(from)) return false;
        localVisited.set(from);
        
        for (Integer to : graph[from]) {
            if (!dfs(graph, to, globalVisited, localVisited)) return false;
        }
        localVisited.set(from, false);
        graph[from].clear();
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            graph[edge[0]].add(edge[1]);
        }

        BitSet globalVisited = new BitSet(numCourses);
        BitSet localVisited = new BitSet(numCourses);
        for (int i = 0; i < graph.length; i++) {
            if (!dfs(graph, i, globalVisited, localVisited)) return false;
        }
        return true;
    }
}
