class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> toFill = new ArrayDeque<>();
        for (int row = 1; row < m - 1; row++) {
            for (int col = 1; col < n - 1; col++) {
                queue.addLast(row);
                queue.addLast(col);
                boolean suraunded = true;
                while (!queue.isEmpty()) {
                    int r = queue.removeFirst();
                    int c = queue.removeFirst();
                    if (board[r][c] == 'X' || visited[r][c]) continue;
                    visited[r][c] = true;
                    if (r == 0 || c == 0 || r == m - 1 || c == n - 1) {
                        suraunded = false;
                        continue;
                    }
                    toFill.addLast(r);
                    toFill.addLast(c);
                    for (int[] dir : DIRECTIONS) {
                        queue.addLast(r + dir[0]); 
                        queue.addLast(c + dir[1]);
                    }
                }
                if (!suraunded) toFill.clear();
                while (!toFill.isEmpty()) {
                    int r = toFill.removeFirst();
                    int c = toFill.removeFirst();
                    board[r][c] = 'X';
                }
            }
        }
        
    }
}
