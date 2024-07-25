class Solution {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operands = Set.of("+", "-", "*", "/");

        for (String token: tokens) {
            if (operands.contains(token)) {
                int first = Integer.parseInt(stack.pop());
                int second = Integer.parseInt(stack.pop());
                int result = calculate(second, first, token.toCharArray()[0]);
                stack.push(String.valueOf(result));
            } else {
                stack.push(token);
            }  
        }

        return Integer.parseInt(stack.pop());
    }

    public static int calculate(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
    
}