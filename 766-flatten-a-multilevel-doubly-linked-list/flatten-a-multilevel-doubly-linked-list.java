/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node current = new Node(11);
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            current.next = node;
            node.prev = current;
            current.child = null;
            current = node;
            if (node.next != null) {
                stack.push(node.next);
            }

            if (node.child != null) {
                stack.push(node.child);
            }
        }

        head.prev = null;
        return head;
    }
}