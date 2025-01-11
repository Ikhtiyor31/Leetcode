class Solution {
     
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String operation: operations) {
            if (!operation.equals("C") && !operation.equals("D") && !operation.equals("+")) {
                stack.push(Integer.parseInt(operation));
            } else {
                if (operation.equals("C")) {
                    stack.pop();
                } else if (operation.equals("D")) {
                    stack.push(stack.peek() * 2);
                } else {
                    int top = stack.pop();
                    int add = top + stack.peek();
                    stack.push(top);
                    stack.push(add);
                }
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}