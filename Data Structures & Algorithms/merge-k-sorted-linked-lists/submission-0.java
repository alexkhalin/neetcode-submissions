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
    private ListNode getMin(ListNode[] lists) {
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            if (list != null && list.val < minVal) {
                minVal = list.val;
                minIndex = i;
            } 
        }
        if (minIndex == -1) return null;

        ListNode minNode = lists[minIndex];
        lists[minIndex] = lists[minIndex].next;
        return minNode;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            curr.next = getMin(lists);
            curr = curr.next;
        }
        return head.next;
    }
}
