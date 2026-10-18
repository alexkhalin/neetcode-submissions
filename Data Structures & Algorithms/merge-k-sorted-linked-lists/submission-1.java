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

    private void heapify(ListNode[] lists, int curr) {
        int len = lists.length;
        while (curr < len) {
            int left = 2 * curr;
            int right = 2 * curr + 1;

            int smallest = curr;
            if (left < len && (lists[smallest] == null || lists[left] != null && lists[smallest].val > lists[left].val)) {
                smallest = left;
            }
            
            if (right < len && (lists[smallest] == null || lists[right] != null && lists[smallest].val > lists[right].val)) {
                smallest = right;
            }

            if (smallest == curr) break;

            ListNode temp = lists[curr];
            lists[curr] = lists[smallest];
            lists[smallest] = temp;

            curr = smallest;
        }
    }

    private void buildHeap(ListNode[] lists) {
        for (int i = lists.length / 2; i >= 0; i--) {
            heapify(lists, i);
        }
    }

    private ListNode getMin(ListNode[] lists) {
        ListNode min = lists[0];
        if (min != null) {
            lists[0] = min.next;
            heapify(lists, 0);
        }
        return min;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        
        buildHeap(lists);
        ListNode head = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            curr.next = getMin(lists);
            curr = curr.next;
        }
        return head.next;
    }
}
