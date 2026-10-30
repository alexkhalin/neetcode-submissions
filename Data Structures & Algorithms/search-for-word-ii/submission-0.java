class Solution {
    private static int CHAR_NUM = 'z' - 'a' + 1;
    private static class TrieNode {
        TrieNode[] children;
        String key;
        int childrenNum;
        boolean isFinal;
    }

    private static void add(TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = 0; i != word.length(); i++) {
            if (curr.children == null) {
                curr.children = new TrieNode[CHAR_NUM]; 
            }
            int charIdx = word.charAt(i) - 'a';
            
            if (curr.children[charIdx] == null) {
                curr.children[charIdx] = new TrieNode();
                curr.childrenNum++;
            }
            curr = curr.children[charIdx];
        }
        curr.key = word;
        curr.isFinal = true;
    }

    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            add(root, word);
        }

        return root;
    }

    private static void backtrack(char[][] board, int row, int col, TrieNode parent, List<String> res) {
        if (row < 0 || row >= board.length 
         || col < 0 || col >= board[row].length
         || board[row][col] == ' ' || parent.children == null) {
            return;
        }

        char ch = board[row][col];
        int charIdx = ch - 'a';
        TrieNode current = parent.children[charIdx];
        if (current == null) return;

        if (current.isFinal) {
            res.add(current.key);
            current.isFinal = false;
        }

        board[row][col] = ' ';
        backtrack(board, row - 1, col, current, res);
        backtrack(board, row + 1, col, current, res);
        backtrack(board, row, col - 1, current, res);
        backtrack(board, row, col + 1, current, res);
        board[row][col] = ch;

        if (current.childrenNum == 0) {
            parent.children[charIdx] = null;
            parent.childrenNum--;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        List<String> res = new ArrayList();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                backtrack(board, row, col, root, res);
            }
        }

        return res;
    }
}
