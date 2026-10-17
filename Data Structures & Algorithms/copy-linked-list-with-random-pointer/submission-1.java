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

        //[[1,null],[2,2],[3,2]]

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        curr = head;
        while (curr != null) {
            Node random = curr.random;
            curr = curr.next;
            if (random != null) curr.random = random.next;
            curr = curr.next;
        }

        Node dummy = new Node(0);
        Node copy = dummy;
        curr = head;
        while (curr != null) {
            copy.next = curr.next;
            copy = copy.next;
            curr.next = copy.next;
            curr = curr.next;
            
        }
        return dummy.next;
    }
}
