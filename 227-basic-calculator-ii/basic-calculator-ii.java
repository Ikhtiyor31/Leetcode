class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int currentNum = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currentNum = currentNum * 10 + (c - '0'); 
            }

            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1) {
                if (operator == '-') {
                    stack.push(-currentNum);
                } else if (operator == '+') {
                    stack.push(currentNum);
                } else if (operator == '*') {
                    stack.push(stack.pop() * currentNum);
                } else if (operator == '/') {
                    stack.push(stack.pop() / currentNum);
                }
                operator = c;
                currentNum = 0;
            }
        }
        
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}