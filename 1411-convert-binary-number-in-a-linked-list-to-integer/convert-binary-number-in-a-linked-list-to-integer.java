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

    public int binaryToInteger(List<Integer> list) {
        int result = 0;
        int current = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 1) {
                result += (Math.pow(2, current));
            }
            current += 1;
        }

        return result;
    }

    public int getDecimalValue(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return binaryToInteger(list);
    }
}