class Solution {
    public boolean isMonotonic(int[] nums) {
          
        Stack<Integer> stack = new Stack<>();
        boolean isIncreasing = true;
        for (int num: nums) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else {
                if (stack.peek() > num) {
                     isIncreasing = false;
                } 
                stack.push(num);
            }
        }

        int num = stack.pop();
        boolean isDecreasing = true;
        while (!stack.isEmpty()) {
            if (num <= stack.peek()) {
                num = stack.pop();
                System.out.println(num);
            } else {
                isDecreasing = false;
                break;
            }
        }
        
        return isIncreasing || isDecreasing;
    }
}