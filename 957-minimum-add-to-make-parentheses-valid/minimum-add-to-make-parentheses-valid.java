class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> parenheses = new Stack<>();
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                parenheses.push(c);
                count++;
            } else {
                if (!parenheses.isEmpty() && c == ')' && parenheses.peek() == '(') {
                    parenheses.pop();
                    count--;
                } else {
                    parenheses.push(c);
                    count++;
                }
            }
        }

        return count;
    }
}