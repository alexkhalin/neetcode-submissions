class Solution {

    private static int countArea(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length || grid[row][col] != 1) return 0;
        grid[row][col] = 0;
        return countArea(grid, row + 1, col) + countArea(grid, row - 1, col)
             + countArea(grid, row, col + 1) + countArea(grid, row, col - 1) + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    maxArea = Math.max(maxArea, countArea(grid, row, col));
                }
            }
        }
        return maxArea;
    }
}
