class Solution {
    private static final char FIRST_LETTER = 'a';
    private static final int LETTER_NUMBER = 'z' - 'a' + 1;

    private static class Node {
        char ch;
        int discovered = Integer.MIN_VALUE;
        List<Node> next = new ArrayList<>();

        Node(char ch) {
            this.ch = ch;
        }
    }

    private Character[] firstDiff(String left, String right) {
        int len = Math.min(left.length(), right.length());
        int i = 0;
        for (; i < len && left.charAt(i) == right.charAt(i); i++) {}

        Character leftChar = i < left.length() ? left.charAt(i) : null;
        Character rightChar = i < right.length() ? right.charAt(i) : null;
        return new Character[] {leftChar, rightChar};
    }


    private List<Node> buildGraph(String[] words) {
        List<Node> graph = new ArrayList<>();
        int[] charToIdx = new int[LETTER_NUMBER];
        Arrays.fill(charToIdx, -1);
        for (String word: words) {
            for (char c : word.toCharArray()) {
                int charIdx = c - FIRST_LETTER;
                if (charToIdx[charIdx] == -1) {
                    charToIdx[charIdx] = graph.size();
                    graph.add(new Node(c));
                }
            }
        }
    
        for (int i = 1; i < words.length; i++) {
            Character[] diff = firstDiff(words[i - 1], words[i]);
            Character left = diff[0];
            Character right = diff[1];
            if (right == null && left != null) return null;
            if (left == null) continue;
            int leftIdx = charToIdx[left.charValue() - FIRST_LETTER];
            int rightIdx = charToIdx[right.charValue() - FIRST_LETTER];
            graph.get(leftIdx).next.add(graph.get(rightIdx));
        }
        return graph;
    }

    private int dfs(Node fromNode, char[] alphabet, int currLetterIdx, int iteration) {
        if (fromNode.discovered == iteration) throw new IllegalArgumentException(""+fromNode.ch);
        if (fromNode.discovered != Integer.MIN_VALUE) return currLetterIdx;
        fromNode.discovered = iteration;
        for (Node toNode : fromNode.next) {
            currLetterIdx = dfs(toNode, alphabet, currLetterIdx, iteration);
        }
        alphabet[currLetterIdx] = fromNode.ch;
        fromNode.discovered = -1;
        return --currLetterIdx;
    }

    public String foreignDictionary(String[] words) {
        List<Node> graph = buildGraph(words);
        if (graph == null) return "";

        char[] alphabet = new char[graph.size()];
        int currLetterIdx = graph.size() - 1;
        for (int i = 0; i < graph.size(); i++) {
            try {
                currLetterIdx = dfs(graph.get(i), alphabet, currLetterIdx, i);
            } catch (IllegalArgumentException e) {
                return "";
            }
        }

        return new String(alphabet);
    }
}
