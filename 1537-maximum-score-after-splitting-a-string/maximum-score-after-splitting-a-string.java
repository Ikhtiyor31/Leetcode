class Solution {
    public int maxScore(String s) {
        
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        int maxScore = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones--;
            } else {
                zeros++;
            }
            maxScore = Math.max(maxScore, ones + zeros);
        }

        return maxScore;
    }

}