class Solution {
    public long minimumSteps(String s) {
        
        int n = s.length();
        long count = 0;
        int whiteCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                count += i - whiteCount;
                whiteCount++;
            }
        }

        return count;
    }
}

// 00101010101101011011010