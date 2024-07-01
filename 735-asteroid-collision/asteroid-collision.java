class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--) {
            if (!stack.isEmpty() && stack.peek() < 0) {
                if (asteroids[i] < 0) {
                    stack.push(asteroids[i]);
                } else if (Math.abs(stack.peek()) == asteroids[i]) {
                    stack.pop();
                } else {
                    boolean both = false;
                    boolean asteroidWin = false;

                    while(!stack.isEmpty() && stack.peek() < 0 &&  Math.abs(stack.peek()) <= Math.abs(asteroids[i])) {
                        if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
                            both = true;
                            stack.pop();
                            break;
                        } else {
                            if (!stack.isEmpty() && Math.abs(stack.peek()) <= Math.abs(asteroids[i]))
                                    asteroidWin = true;
                             stack.pop();
                             
                              
                        }
                    }

                    if (!stack.isEmpty() && stack.peek() < 0 && Math.abs(stack.peek()) > Math.abs(asteroids[i]))
                            asteroidWin = false;

                    System.out.println(asteroids[i]);
                    if (both) continue;

                    if (asteroidWin) {
                        stack.push(asteroids[i]);
                    }
                   
                }
            } else {
                stack.push(asteroids[i]);
            }
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