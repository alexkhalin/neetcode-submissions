class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;
        int[] rows = new int[size];
        int[] cols = new int[size];
        int[] sqr = new int[size];

        for (int r = 0; r < size; ++r) {
            for (int c = 0; c < size; ++c) {
                int num = board[r][c] - '1';
                if (num < 0) continue;
                int flag = 1 << num;
                int s = r / 3 * 3 + c / 3;

                if (((rows[r] | cols[c] | sqr[s]) & flag) != 0) {
                    return false;
                }
                
                rows[r] |= flag;
                cols[c] |= flag;
                sqr[s] |= flag;
            }
        }
        return true;
    }
}
