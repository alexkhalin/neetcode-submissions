class WordDictionary {
    private static class TrieNode {
        TrieNode[] children;
        boolean isFinal;
    }

    TrieNode root = new TrieNode();

    public WordDictionary() {

    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children == null) curr.children = new TrieNode[26];
            int childIdx = word.charAt(i) - 'a';
            if (curr.children[childIdx] == null) curr.children[childIdx] = new TrieNode();
            curr = curr.children[childIdx];
        }
        curr.isFinal = true;
    }

    private boolean search(String word, TrieNode curr, int idxFrom) {
        if (idxFrom == word.length()) return curr.isFinal;

        if (curr.children == null) return false;

        char ch = word.charAt(idxFrom);
        idxFrom++;
        if (ch == '.') {
            for (TrieNode child : curr.children) {
                if (child != null && search(word, child, idxFrom)) {
                    return true;
                }
            }
            return false;
        } else {
            
            TrieNode child = curr.children[ch - 'a'];
            return child != null && search(word, child, idxFrom);
        }
    }

    public boolean search(String word) {
       return search(word, root, 0);
    }
}
