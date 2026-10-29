class PrefixTree {

    private static class Node {
        char[] key;
        int idxTo;
        Node[] children;
        boolean isFinal;

        Node(char[] key, int idxTo, boolean isFinal) {
            this.key = key;
            this.idxTo = idxTo;
            this.isFinal = isFinal;
        }
    }

    private Node root;
    public PrefixTree() {
        root = new Node(null, 0, false);
    }

    public void insert(String word) {
        char[] wordArray = word.toCharArray();
        Object[] res = lastNode(wordArray);
        Node curr = (Node) res[0];
        int lastIdx = (Integer) res[1];
        if (lastIdx < curr.idxTo) {
            Node reminder = new Node(curr.key, curr.idxTo, curr.isFinal);
            reminder.children = curr.children;
            curr.idxTo = lastIdx;
            curr.children = new Node[26];
            curr.children[curr.key[lastIdx] - 'a'] = reminder;
            curr.isFinal = false;
        } 
        if (lastIdx < wordArray.length) {
            Node wordNode = new Node(wordArray, wordArray.length, true);
            if (curr.children == null) curr.children = new Node[26];
            curr.children[wordArray[lastIdx] - 'a'] = wordNode;
        } else {
            curr.isFinal = true;
        }
    }

    private Object[] lastNode(char[] word) {
        Node curr = root;
        int wordLen = word.length;
        for (int i = 0; i < wordLen; ) {
            int childIdx = word[i] - 'a';
            if (curr.children == null || curr.children[childIdx] == null) {
                return new Object[] {curr, curr.idxTo};
            }
            curr = curr.children[childIdx];
            int len = Math.min(wordLen, curr.idxTo);
            while (++i < len && word[i] == curr.key[i]);
            if (i < len) {
                return new Object[] {curr, i};
            }
        }
        return new Object[] {curr, wordLen};
    }

    public boolean search(String word) {
        Object[] last = lastNode(word.toCharArray());
        Node curr = (Node) last[0];
        int lastIdx = (Integer) last[1];
        return curr.isFinal && lastIdx == curr.idxTo && lastIdx == word.length();
    }

    public boolean startsWith(String prefix) {
        Object[] last = lastNode(prefix.toCharArray());
        Node curr = (Node) last[0];
        int lastIdx = (Integer) last[1];
        return lastIdx == prefix.length();
    }
}
