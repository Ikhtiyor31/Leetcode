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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode current = head;
        ListNode previous = null;
        ListNode answer = null;
        while (current != null) {
            ListNode tail = current;
            int i = 1;
            for (; i < k && tail != null && tail.next != null; i++) {
                tail = tail.next;
            }
            if (i != k) {
                previous.next = current;
                break;
            }
            ListNode nextStart = tail.next;
            tail.next = null;
            ListNode reversed = reverseNode(current);
            if (answer == null) {
                answer = reversed;
                previous = current;
            } else {
                previous.next = reversed;
                previous = current;
            }
            
            current.next = nextStart;
            current = current.next;
        }

        return answer;
    }

    public ListNode reverseNode(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        while (current != null) {
            ListNode newNode = current.next;
            current.next = previous;
            previous = current;
            current = newNode;
        }

        return previous;
    }
}