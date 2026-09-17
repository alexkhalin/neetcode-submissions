class Solution {
    int size = 9;
    short[] rows = new short[size];
    short[] cols = new short[size];
    short[] sqr = new short[size];
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < size; ++r) {
            for (int c = 0; c < size; ++c) {
                int num = board[r][c] - '1';
                if (num < 0) continue;
                short flag = (short)(1 << num);
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
