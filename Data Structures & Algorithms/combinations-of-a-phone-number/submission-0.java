class Solution {
    char[][] letters = new char[][] {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'},
    };

    private void buildCombinations(String digits, int digitsPos, char[] buff, List<String> res) {
        if (digitsPos == digits.length()) {
            res.add(new String(buff));
            return;
        }
        int setIdx = digits.charAt(digitsPos) - '2';
        for (char letter : letters[setIdx]) {
            buff[digitsPos] = letter;
            buildCombinations(digits, digitsPos + 1, buff, res);
        }
    }

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) return List.of();
        List<String> res = new ArrayList<>();
        buildCombinations(digits, 0, new char[digits.length()], res);

        return res;
    }
}
