class Solution {
    private void checkAndUpdate(int[][] grid, int row, int col, int dist, Deque<Integer> queue) {
        if (grid[row][col] == Integer.MAX_VALUE) {
            grid[row][col] = dist;
            queue.add(row);
            queue.add(col);
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int row = 0; row < grid.length; row++) { 
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 0) {
                    queue.addLast(row);
                    queue.addLast(col);
                }
            }
        }

        while(!queue.isEmpty()) {
            int row = queue.removeFirst();
            int col = queue.removeFirst();
            int dist = grid[row][col];
            dist++;
            if (row > 0) checkAndUpdate(grid, row - 1, col, dist, queue);
            if (row + 1 < grid.length) checkAndUpdate(grid, row + 1, col, dist, queue);
            if (col > 0) checkAndUpdate(grid, row, col - 1, dist, queue);
            if (col + 1 < grid[row].length) checkAndUpdate(grid, row, col + 1, dist, queue);
        }
    }
}
