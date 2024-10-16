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
            for (; i < k && tail.next != null; i++) {
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
            } else {
                previous.next = reversed;
            }
            
            previous = current;
            current = nextStart;
        }

        return answer;
    }

    public ListNode reverseNode(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }

        return previous;
    }
}