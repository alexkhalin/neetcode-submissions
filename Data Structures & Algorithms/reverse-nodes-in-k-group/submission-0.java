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
    private ListNode reverseGroup(ListNode head, int k) {
        if (head.next == null) return null;
        
        ListNode first = head.next;
        ListNode prev = head;
        ListNode curr = head.next;
        int i = 0;
        while(curr != null && i != k) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        head.next = prev;
        first.next = curr;
        if (i < k) first = reverseGroup(head, i);
        return first;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        while (curr != null) {
            curr = reverseGroup(curr, k);
        }
        return dummy.next;
    }
}
