class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        Set<Character> duplicate = new HashSet<>();
        int longestLength = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            
            while (duplicate.contains(s.charAt(i))) {
                duplicate.remove(s.charAt(l++));
            }

            duplicate.add(s.charAt(i));
            
            longestLength = Math.max(longestLength, i - l + 1);
        }

        return longestLength;
    }
}


/*
s = abcabcbb
set = b, c, a, 
        c, a b, c
            a, b, c,
                i
*/