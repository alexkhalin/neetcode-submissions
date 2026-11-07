class Solution {
    public int minCostConnectPoints(int[][] points) {
        boolean[] visited = new boolean[points.length];
        int[] totalMin = new int[points.length];
        Arrays.fill(totalMin, Integer.MAX_VALUE);
        int cost = 0;        
        int[] currPoint = points[0];
        visited[0] = true;
        for (int i = 1; i < points.length; i++) {           
            int minDst = Integer.MAX_VALUE;
            int minIdx = 0;
            int currX = currPoint[0];
            int currY = currPoint[1];
            for (int j = 0; j < points.length; j++) {
                if (visited[j]) continue;
                int[] nextPoint = points[j];
                int nextX = nextPoint[0];
                int nextY = nextPoint[1];
                int currDst = Math.max(currX - nextX, -currX + nextX) + Math.max(currY - nextY, -currY + nextY);
                totalMin[j] = Math.min(totalMin[j], currDst);
                if (totalMin[j] < minDst) {
                    minDst = totalMin[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = true;
            cost += minDst;
            currPoint = points[minIdx];
        }
        return cost;        
    }
}
