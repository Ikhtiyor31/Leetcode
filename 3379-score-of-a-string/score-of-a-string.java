class Solution {
    public int scoreOfString(String s) {
        

        int sum = 0;
        int prev = -1;
        for (char c: s.toCharArray()) {
            if (prev == -1) {
                prev = (int) c;
            } else {
                sum += Math.abs(prev - (int) c);
            }
            prev = (int) c;
        }

        return sum;
    }
}