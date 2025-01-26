class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int largestArea = 0;
        /*for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            largestArea = Math.max(largestArea, heights[i]);
            while (l >= 0 && heights[l] >= heights[i]) {
                l--;
            }

            while (r < n && heights[r] >= heights[i]) {
                r++;
            }

            largestArea = Math.max(largestArea, heights[i] * (r - l - 1));
        }*/

        Stack<Integer> stack = new Stack<Integer>();
        int[] leftMinIndex = new int[n];
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                leftMinIndex[i] = -1;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
               
                leftMinIndex[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
                
            }
        }

        stack = new Stack<Integer>();
        int[] rightMinIndex = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
                rightMinIndex[i] = n;
            } else {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                
                rightMinIndex[i] = stack.isEmpty() ? n  : stack.peek();
                stack.push(i);
            }
        }



        for (int i = 0; i < n; i++) {
            largestArea = Math.max(largestArea, heights[i] * (rightMinIndex[i] - leftMinIndex[i]- 1));
        }

        return largestArea;
    }
}

/*

the concept is basically to find first lower or equal number to current from left and right.
to do this, we need two array to keep track minimum or equal. number in the left and minimum or equal to number in the right.
we keep index of non-decreasing numbers in stack 
l = 0 0 2 3 
r = 
0 
*/