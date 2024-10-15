class Solution {
    public long minimumSteps(String s) {
        int black = 0;
        int white = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                black += 1;
            else
                white += 1;
        }
        int n = s.length();
        long whiteCount = 0;

        // go with white
        int indx = 0;
        while (indx < n && s.charAt(indx) != '1') {
                indx++;
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0' && indx < i) {
                whiteCount += (i - indx);
                indx++;
            }
        }
        long blackCount = 0;
        indx = n;
        while (indx > 0 && s.charAt(indx - 1) != '0') {
                indx--;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1' && indx > i) {
                blackCount += (indx - i);
            }
        }
      
        return Math.min(whiteCount, blackCount);
    }
}

// 00101010101101011011010