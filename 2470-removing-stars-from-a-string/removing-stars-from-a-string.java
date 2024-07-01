class Solution {
    public String removeStars(String s) {
        
        int n = s.length();
        String answer = "";
        int starCnt = 0;
        for(int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '*' && starCnt == 0) {
                answer = s.charAt(i) + answer;
            } else if (s.charAt(i) == '*') {
                starCnt++;
            } else {
                starCnt--;
            }
        }

        return answer;
    }
}