class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int n = temperatures.length;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {
                    result[i] = stack.peek() - i;
                }
                stack.push(i);
            }
        }


        return result;
    }
}

/*
[73, 74, 75, 71, 69, 72, 76, 73]
              1  1  0  0

[73, 74, 75, 75, 75, 75, 76, 76]
[69, 69, 69, 69, 69, 72, 73, 73]

*/