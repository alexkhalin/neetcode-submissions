/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Integer, Node> copied = new HashMap<>();
    public Node cloneGraph(Node node) {

        if (node == null) return null;

        Node copy = copied.get(node.val);
        if (copy != null) return copy;

        copy = new Node(node.val, new ArrayList<>(node.neighbors.size()));
        copied.put(copy.val, copy);
        
        for(Node neighbor: node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }
        return copy;
    }
}