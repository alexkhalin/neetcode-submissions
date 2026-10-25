class Solution {
    private static void backTrack(int n, int level, int idx, char[] buff, List<String> res) {
        if (idx == buff.length) {
            res.add(new String(buff));
            return;
        }

        if (n > 0) {
            buff[idx] = '(';
            backTrack(n - 1, level + 1, idx + 1, buff, res);
        }
        if (level > 0) {
            buff[idx] = ')';
            backTrack(n, level - 1, idx + 1, buff, res);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backTrack(n, 0, 0, new char[n * 2], res);
        return res;
    }
}
