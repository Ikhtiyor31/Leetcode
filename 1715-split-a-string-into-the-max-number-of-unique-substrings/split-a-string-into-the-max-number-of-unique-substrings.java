class Solution {

    public int backtrack(String s, Set<String> uniqueSubstring, int curr) {

        if (curr >= s.length()) {
            return 0;
        }
        int max = 0;
        for (int i = curr + 1; i <= s.length(); i++) {
            String sub = s.substring(curr, i);
            if (!uniqueSubstring.contains(sub)) {
                uniqueSubstring.add(sub);
                int count = 1 + backtrack(s, uniqueSubstring, i);
                max = Math.max(count, max);
                uniqueSubstring.remove(sub);
            }
        }

        return max;
    }

    public int maxUniqueSplit(String s) {
        
        Set<String> uniqueSubstring = new HashSet<>();
        return backtrack(s, uniqueSubstring, 0);
    }
}