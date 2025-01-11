class Solution {
     
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String operation: operations) {
            if (operation.equals("C")) {
                stack.pop();
            } else if (operation.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (operation.equals("+")) {
                int top = stack.pop();
                int add = top + stack.peek();
                stack.push(top);
                stack.push(add);
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }

        int result = 0;
        for (int score: stack) {
            result += score;
        }
        return result;
    }
}