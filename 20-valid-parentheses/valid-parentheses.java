class Solution {
    public boolean isValid(String s) {
         
         Stack<Character> stack = new Stack<>();

         for (Character ch: s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (!stack.isEmpty() && stack.pop() == reversed(ch)) {
                continue;
            } else {
                return false;
            }
         }

         return stack.isEmpty();
    }

    public static char reversed(char c) {
        if (c == ')')
            return '(';
        else if (c == '}') 
            return '{';
        else 
            return '[';
    }
}