class Solution {
    private static boolean backTrack(char[][] board, String word, int idx, int r, int c) {
        
        char ch = word.charAt(idx);
        if (board[r][c] != ch) return false;
        idx++;
        if (idx == word.length()) return true;
        board[r][c] = ' ';

        boolean res = r > 0 && backTrack(board, word, idx, r - 1, c)
            || r + 1 < board.length && backTrack(board, word, idx, r + 1, c)
            || c > 0 && backTrack(board, word, idx, r, c - 1)
            || c + 1 < board[r].length && backTrack(board, word, idx, r, c + 1);
        board[r][c] = ch;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (backTrack(board, word, 0, r, c)) return true;
            }
        }

        return false;
    }
}
