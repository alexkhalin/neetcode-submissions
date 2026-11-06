class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((p1, p2) -> p1[0] - p2[0]);
        BitSet visited = new BitSet(points.length);
        int counter = points.length;
        int cost = 0;
        queue.add(new int[]{0, 0});
        while (true) {
            int[] curr = queue.remove();
            if (visited.get(curr[1])) continue;
            cost += curr[0];
            if (--counter == 0) break;
            visited.set(curr[1]);
            int[] currPoint = points[curr[1]];
            for (int i = points.length; (i = visited.previousClearBit(i-1)) >= 0; ) {
                int[] nextPoint = points[i];
                int mdist = Math.abs(currPoint[0] - nextPoint[0]) + Math.abs(currPoint[1] - nextPoint[1]);
                queue.add(new int[]{mdist, i});
            }
        }
        return cost;
        
    }
}
