class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int longestLength = 0;
        int l = 0;
        Map<Character, Integer> freq = new HashMap<>();
        for (int r = 0; r < n; r++) {
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);

            while (freq.get(s.charAt(r)) > 1) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }

            longestLength = Math.max(longestLength, r - l + 1);
        }

        return longestLength;
    }
}
// Time: O(N) * O(N) * O(1) -> (N^2)
// Space: O(N) // we may store N characters at most at any given time.

/*
s = abcabcbb
set = b, c, a, 
        c, a b, c
            a, b, c,
                i
s = abcabcbb longestLenght = Math.max(longestLength, r - l + 1);
    01234567
       l  r
    abcabc
    
    c=2

*/