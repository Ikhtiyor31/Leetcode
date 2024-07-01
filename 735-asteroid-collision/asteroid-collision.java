class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            
            int asteroid = asteroids[i];
            boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek() < 0 && asteroid > 0) {
                int top = stack.peek();
                if (-top == asteroid) {
                    stack.pop();
                    destroyed = true;
                    break;
                } else if (-top > asteroid) {
                    destroyed = true;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (!destroyed) stack.push(asteroid);
        }

        int answer[] = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()) {
            answer[i++] = stack.peek();
            stack.pop();
        }
        return answer;
    }
}