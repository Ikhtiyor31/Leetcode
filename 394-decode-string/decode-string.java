class Solution {
    public String decodeString(String s) {
        
        Stack<Character> stack = new Stack<>();
        String current = "";
        String answer = "";
        for (Character c : s.toCharArray()) {
            if (c == ']') {
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    current = stack.pop() + current;
                }
                // pop [
                stack.pop();

                String strNum = "";
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    strNum = stack.pop() + strNum;
                }
                current = current.repeat(Integer.parseInt(strNum));
                for (char ch: current.toCharArray()) {
                    stack.push(ch);
                }
                current = "";
            } else {
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            answer = stack.pop() + answer;
        }
        return answer;
    }
}