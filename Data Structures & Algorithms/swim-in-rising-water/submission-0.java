class Solution {
    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void addNeighbors(int[][] grid, int time, int row, int col, PriorityQueue<int[]> queue) {
        for (int[] dir: DIRS) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];
            if (nextRow < 0 || nextRow >= grid.length 
                || nextCol < 0 || nextCol >= grid[0].length 
                || grid[nextRow][nextCol] == Integer.MAX_VALUE) continue;

                queue.add(new int[] {Math.max(time, grid[nextRow][nextCol]), nextRow, nextCol});
            //    grid[nextRow][nextCol] = Integer.MAX_VALUE;
        }
    }

    public int swimInWater(int[][] grid) {
        final int targetRow = grid.length - 1;
        final int targetCol = grid[0].length - 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((s1, s2) -> s1[0] - s2[0]);
        int time = grid[0][0];
        int row = 0;
        int col = 0;
        while(row != targetRow || col != targetCol) {
            grid[row][col] = Integer.MAX_VALUE;
            addNeighbors(grid, time, row, col, queue);
            int[] next = queue.remove();
            time = next[0];
            row = next[1];
            col = next[2]; 
        }
        return time;
    }
}
