class PrefixTree {

    private static class Node {
        Node[] children = new Node[26];
        boolean isFinal = false;
    }

    private Node root;
    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            if (curr.children[childIdx] == null) {
                curr.children[childIdx] = new Node();
            }
            curr = curr.children[childIdx];
        }
        curr.isFinal = true;
    }

    private Node lastNode(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int childIdx = word.charAt(i) - 'a';
            curr = curr.children[childIdx];
            if (curr == null) {
                return null;
            }
        }
        return curr;
    }

    public boolean search(String word) {
        Node last = lastNode(word);
        return last != null && last.isFinal;
    }

    public boolean startsWith(String prefix) {
        Node last = lastNode(prefix);
        return last != null;
    }
}
