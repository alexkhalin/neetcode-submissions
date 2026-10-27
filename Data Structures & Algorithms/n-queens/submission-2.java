class Solution {
    private List<String> buildSolution(int[] buff) {
        List<String> solution = new ArrayList<>();

        for (int row = 0; row != buff.length; row++){
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col != buff.length; col++) {
                sb.append(col == buff[row] ? 'Q' : '.');
            }
            solution.add(sb.toString());
        } 
        return solution;
    }

    private void backTrack(int[] buff, int row, long flags, List<List<String>> res) {
        int len = buff.length;
        if (row == len) {
            res.add(buildSolution(buff));
        }

        for (int col = 0; col != len; col++) {
            int diag1 = row + col;
            int diag2 = row - col + len;
            long mask = (1L << (diag1)) | (1L << (diag2 + (len << 1))) | (1L << col + (len << 2));
            if ((flags & mask) == 0) {
                flags |= mask;
                buff[row] = col;
                backTrack(buff, row + 1, flags, res);
                flags ^= mask;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backTrack(new int[n], 0, 0, res);
        return res;
    }
}
