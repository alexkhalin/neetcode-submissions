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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list2 == null) return list1;
        ListNode headPointer = new ListNode(0, list1);
        ListNode branch = list2; 
        ListNode main = headPointer;
        while (main.next != null && branch != null) {
            if (branch.val < main.next.val) {
                ListNode temp = main.next;
                main.next = branch;
                branch = temp;
            }
            main = main.next;
        }
        main.next = branch;

        return headPointer.next;
    }
}