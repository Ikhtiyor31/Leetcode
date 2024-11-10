class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid: asteroids) {
            if (stack.isEmpty()) {
                stack.push(asteroid);
            } else {
                int win = 0;
                while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                    if (Math.abs(asteroid) == stack.peek()) {
                        win = 2;
                        stack.pop();
                        break;
                    } else if (Math.abs(asteroid) > stack.peek()) {
                        win = 1;
                        stack.pop();
                    } else {
                        win = 2;
                        break;
                    }
                }
                
                if (win == 0 || win == 1) {
                    stack.push(asteroid);
                }
            }
        }


        int[] ans = new int[stack.size()];
        int n = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[n--] = stack.pop();
        }


        return ans;
    }
}

/*
[10, -7, -5]

[5, 10, -5]


[-5,7]

*/