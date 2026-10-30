class Solution {
    private static void fillIsland(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != '1') return;
        grid[row][col] = '2';
        fillIsland(grid, row + 1, col);
        fillIsland(grid, row - 1, col);
        fillIsland(grid, row, col + 1);
        fillIsland(grid, row, col - 1);
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    fillIsland(grid, row, col);
                }
            }
        }

        return count;
    }
}
