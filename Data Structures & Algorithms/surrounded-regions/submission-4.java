class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void markDFS(char[][] board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 'O') return;

        board[row][col] = '1';
        for (int[] dir : DIRECTIONS) {
            markDFS(board, row + dir[0], col + dir[1]);
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int row = 0; row < m; row++) {
            markDFS(board, row, 0);
            markDFS(board, row, n - 1);
        }
        for (int col = 1; col < n - 1; col++) {
            markDFS(board, 0, col);
            markDFS(board, m - 1, col);
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                char ch = board[row][col];
                if (ch != 'X') {
                    board[row][col] = ch == '1' ? 'O' : 'X';
                }
            }
        }
        
    }
}
