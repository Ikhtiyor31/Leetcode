class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int unbalanced = 0;
        for (char bracket: s.toCharArray()) {

            if (bracket == '[') {
                stack.push(bracket);
            } else {
                if (!stack.isEmpty()) stack.pop();
                else unbalanced++;
            }
        }

        return (unbalanced + 1) / 2;
    }
}