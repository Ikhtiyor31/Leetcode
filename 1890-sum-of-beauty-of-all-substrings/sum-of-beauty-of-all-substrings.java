class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int answer = 0;
        int k = 0;
        while (k < n) {
            freq = new int[26];
            for (int i = k; i < n; i++) {
                int minFreq = Integer.MAX_VALUE;
                int maxFreq = 0;
                int c = s.charAt(i) - 'a';
                freq[c]++;

                for (int j = 0; j < 26; j++) {
                    maxFreq = Math.max(maxFreq, freq[j]);
                    if (freq[j] != 0) {
                        minFreq = Math.min(minFreq, freq[j]);
                    }
                }

                if (minFreq != Integer.MAX_VALUE && maxFreq >= 2) {
                    answer += maxFreq - minFreq;
                }
            }
            k++;
        }
        
        return answer;
    }
}
/* 

s = "aabcbaa"
       22234 
       11111 
       11123 = 8
      211 
*/