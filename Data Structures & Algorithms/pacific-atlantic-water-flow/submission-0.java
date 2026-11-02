class Solution {
    private static final int PACIFIC = 1 << 30;
    private static final int ATLANTIC = 1 << 29;
    private static final int BOTH = PACIFIC | ATLANTIC;
    private static final int HEIGHT_MASK = ~(PACIFIC | ATLANTIC);
    
    private static void dfs(int[][] heights, int row, int col, int flag, int prevHeight, List<List<Integer>> res) {
        int val = heights[row][col];
        int currHeight = val & HEIGHT_MASK;
        if ((val & flag) != 0 || prevHeight > currHeight) return;

        heights[row][col] |= flag;

        if ((heights[row][col] & BOTH) == BOTH) res.add(List.of(row, col));

        if (row > 0) dfs(heights, row - 1, col, flag, currHeight, res);
        if (col > 0) dfs(heights, row, col - 1, flag, currHeight, res);
        if (row < heights.length - 1) dfs(heights, row + 1, col, flag, currHeight, res);
        if (col < heights[0].length - 1) dfs(heights, row, col + 1, flag, currHeight, res);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;
        byte[][] flags = new byte[m][n];

        for (int row = 0; row < m; row++) {
            dfs(heights, row, 0, PACIFIC, 0, res);
            dfs(heights, row, n - 1, ATLANTIC, 0, res);
        }
        for (int col = 0; col < n; col++) {
            dfs(heights, 0, col, PACIFIC, 0, res);
            dfs(heights, m - 1, col, ATLANTIC, 0, res);
        }

        return res;
    }
}
