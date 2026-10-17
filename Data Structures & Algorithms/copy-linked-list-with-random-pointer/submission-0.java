/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node curr = head;
        Node copy = dummy;
        while (curr != null) {
            copy.next = new Node(curr.val);
            map.put(curr, copy.next);
            curr = curr.next;
            copy = copy.next;
        }

        curr = head;
        copy = dummy.next;
        while (curr != null) {
            copy.random = map.get(curr.random);
            curr = curr.next;
            copy = copy.next;
        }

        return dummy.next;
    }
}
