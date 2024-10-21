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
    public ListNode insertionSortList(ListNode head) {
        ListNode ret = new ListNode();

        while (head != null) {
            ListNode copy = ret;

            while (copy.next != null && copy.next.val <= head.val) {
                copy = copy.next;
            }

            ListNode takeNext = head.next;
            head.next = copy.next;
            copy.next = head;
            head = takeNext;
        }

        return ret.next;

    }
}
/*
0 -> 2 -> 4
*/