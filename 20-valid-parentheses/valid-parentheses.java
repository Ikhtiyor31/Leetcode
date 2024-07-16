class Solution {
    public boolean isValid(String s) {
         
         Stack<Character> stack = new Stack<>();

         for (Character ch: s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    if (ch == ')' && stack.peek() == '(') {
                        stack.pop();
                    } else if (ch == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else if (ch == ']' && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                   
                } else {
                         
                    return false;
                }
            }
         }

         return stack.isEmpty();
    }
}