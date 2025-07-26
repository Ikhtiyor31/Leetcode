class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        int score = 0;
        boolean isXRemoved = false;
        if (x >= y) {
            isXRemoved = true;
            for (char c: s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == 'a' && c == 'b') {
                        score += x;
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
            // ab
        } else {
            // ba
            for (char c: s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == 'b' && c == 'a') {
                        score += y;
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        s = sb.reverse().toString();

        if (isXRemoved) {
            // ba
             for (char c: s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == 'b' && c == 'a') {
                        score += y;
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
        } else {
            // ab
            for (char c: s.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == 'a' && c == 'b') {
                        score += x;
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }
        }

        return score;
    }
}