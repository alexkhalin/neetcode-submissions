class Solution {
    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    private static void findPalindromes(String s, int from, List<String> curr, List<List<String>> res) {
        if (from == s.length()) {
            res.add(new ArrayList(curr));
            return;
        }

        for (int to = from; to < s.length(); to++) {
            if (!isPalindrome(s, from, to)) continue;
            curr.add(s.substring(from, to + 1));
            findPalindromes(s, to + 1, curr, res);
            curr.removeLast();
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        findPalindromes(s, 0, new ArrayList<>(), res);
        return res;    
    }
}
