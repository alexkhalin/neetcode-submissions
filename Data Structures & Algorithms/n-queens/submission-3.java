class Solution {
    private List<String> buildSolution(int[] buff, List<String> templates) {
        List<String> solution = new ArrayList<>();
        for (int col : buff) {
            solution.add(templates.get(col));
        } 
        return solution;
    }

    private void backTrack(int[] buff, int row, long flags, List<List<String>> res, List<String> templates) {
        int len = buff.length;
        if (row == len) {
            res.add(buildSolution(buff, templates));
        }

        for (int col = 0; col != len; col++) {
            int diag1 = row + col;
            int diag2 = row - col + len;
            long mask = (1L << (diag1)) | (1L << (diag2 + (len << 1))) | (1L << col + (len << 2));
            if ((flags & mask) == 0) {
                flags |= mask;
                buff[row] = col;
                backTrack(buff, row + 1, flags, res, templates);
                flags ^= mask;
            }
        }
    }

    List<String> buildTemplates(int n) {
        List<String> templates = new ArrayList<>();

        char[] arr = new char[n];
        Arrays.fill(arr, '.');
        for (int row = 0; row != n; row++){
            arr[row] = 'Q';
            templates.add(new String(arr));
            arr[row] = '.';
        } 
        return templates;
    }


    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backTrack(new int[n], 0, 0, res, buildTemplates(n));
        return res;
    }

}
