class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int largestArea = 0;
        /* this is O(N^2) solution
        
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            int current = heights[i];
            largestArea = Math.max(largestArea, current);
            
            while (l >= 0 && heights[l] >= current) {
                l--;
            }

            while (r < n && heights[r] >= current) {
                r++;
            }

            largestArea = Math.max(largestArea, current * (r - l - 1));
        } */

        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
              stack.push(i);  
              left[i] = 0;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
                stack.push(i);
            }
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
              stack.push(i);  
              right[i] = n - 1;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
                stack.push(i);
            }
        }
        
        for (int i = 0; i < n; i++) {
            largestArea = Math.max(largestArea, heights[i] * (right[i] - left[i] + 1));
        }

        return largestArea;
    }
}