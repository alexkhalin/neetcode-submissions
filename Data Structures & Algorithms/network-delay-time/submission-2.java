class Solution {
    private static final int NOT_VISITED = 1_000_000;
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] bestTime = new int[n + 1];
        Arrays.fill(bestTime, NOT_VISITED);
        bestTime[k] = 0;

        boolean found = true;
        for (int i = 0; i < n && found; i++) {
            found = false;
            for (int[] edge : times) {
                int newTime = bestTime[edge[0]] + edge[2];
                if (newTime < bestTime[edge[1]]) {
                    bestTime[edge[1]] = newTime;
                    found = true;
                }
            }
        }
        int total = 0;
        for (int i = 1; i <= n; i++) {
            int time = bestTime[i]; 
            if (time > total) {
                if (time == NOT_VISITED) return -1;
                total = time;
            }
        }

        return total;
    }
}
