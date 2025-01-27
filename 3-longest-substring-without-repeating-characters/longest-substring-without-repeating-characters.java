class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int longestLength = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> duplicate = new HashSet<>();
            for (int j = i; j < n; j++) {
                if (duplicate.contains(s.charAt(j))) break;
                duplicate.add(s.charAt(j));
            }
            longestLength = Math.max(longestLength, duplicate.size());
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