class Solution {
    private static int[][] DIRECTIONS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshCount = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int val = grid[row][col];
                if (val == 1) {
                    freshCount++;
                } else if (val == 2) {
                    queue.addLast(row);
                    queue.addLast(col);
                }
            }
        }
        
        if (freshCount == 0) return 0;

        while (!queue.isEmpty()) {
            int row = queue.removeFirst();
            int col = queue.removeFirst();

            int val = grid[row][col];
            if (val < 2) continue;
            val++;
            for (int[] dir : DIRECTIONS) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if (nextRow >=0 && nextRow < m && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 1) {
                    if (freshCount == 1) return val - 2;
                    grid[nextRow][nextCol] = val;
                    queue.addLast(nextRow);
                    queue.addLast(nextCol);
                    freshCount--;
                }
            }
        }
        return -1;
    }
}
