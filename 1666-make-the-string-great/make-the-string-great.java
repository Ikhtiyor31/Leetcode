class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for (char c: s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (stack.peek() != c && (stack.peek() == Character.toLowerCase(c) || Character.toLowerCase(stack.peek()) == c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}