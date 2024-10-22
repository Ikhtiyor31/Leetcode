class Solution {
    public int minAddToMakeValid(String s) {
        //Stack<Character> parenheses = new Stack<>();
        int count = 0;
        int need = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                //parenheses.push(c);
                count++;
            } else {
                if (count > 0) {
                    //parenheses.pop();
                    count--;
                } else {
                    //parenheses.push(c);
                    need++;
                }
            }
        }

        return count + need;
    }
}