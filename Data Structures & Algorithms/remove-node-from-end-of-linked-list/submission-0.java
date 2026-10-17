/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        while(right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
