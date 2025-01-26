class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int answer[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                
                if (!stack.isEmpty()) {
                    answer[i] = stack.peek() - i;
                }
                stack.push(i);
            }
        }


        return answer;
    }
}

/*
the idea is to keep track of non-increasing temperature values in stack
as soon as we meet greater value than top of stack, we pop value from stack.

*/