class WordDictionary {
    private static int CHAR_NUM = 'z' - 'a' + 1;

    private static class TrieNode {
        TrieNode[] children;
        char[] key;
        int idxTo;
        boolean isFinal;

        TrieNode(char[] key, int idxTo, boolean isFinal) {
            this.key = key;
            this.idxTo = idxTo;
            this.isFinal = isFinal;
        }
    }

    TrieNode root = new TrieNode(null, 0, false);

    public WordDictionary() {

    }

    public void addWord(String word) {
        char[] wordArray = word.toCharArray();
        TrieNode curr = root;
        int idxFrom = 0;
        while (idxFrom < wordArray.length) {
            if (curr.children == null) curr.children = new TrieNode[CHAR_NUM];
            int childIdx = wordArray[idxFrom] - 'a';
            if (curr.children[childIdx] == null) {
                curr.children[childIdx] = new TrieNode(wordArray, wordArray.length, true);
                return;
            }
            
            curr = curr.children[childIdx];
            int idxTo = Math.min(wordArray.length, curr.idxTo);
            while (++idxFrom != idxTo) {
                if (wordArray[idxFrom] != curr.key[idxFrom]) {
                    TrieNode reminder = new TrieNode(curr.key, curr.idxTo, curr.isFinal);
                    reminder.children = curr.children;
                    curr.children = new TrieNode[CHAR_NUM];
                    curr.children[curr.key[idxFrom] - 'a'] = reminder;
                    curr.children[wordArray[idxFrom] - 'a'] = new TrieNode(wordArray, wordArray.length, true);
                    curr.idxTo = idxFrom;
                    curr.isFinal = false;
                    return;
                }
            };
        }

        if (idxFrom != curr.idxTo) {
            TrieNode reminder = new TrieNode(curr.key, curr.idxTo, curr.isFinal);
            reminder.children = curr.children;
            curr.children = new TrieNode[CHAR_NUM];
            curr.children[curr.key[idxFrom] - 'a'] = reminder;
            curr.idxTo = idxFrom;
        } 
        curr.isFinal = true;

    }

    private boolean search(char[] word, TrieNode curr, int idxFrom) {
        int idxTo = Math.min(word.length, curr.idxTo);
        while (idxFrom != idxTo && (word[idxFrom] == curr.key[idxFrom] || word[idxFrom] == '.'))
            idxFrom++;

        if (idxFrom == word.length) return curr.isFinal && curr.idxTo == idxFrom;

        if (curr.children == null) return false;

        char ch = word[idxFrom];
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
       return search(word.toCharArray(), root, 0);
    }
}
