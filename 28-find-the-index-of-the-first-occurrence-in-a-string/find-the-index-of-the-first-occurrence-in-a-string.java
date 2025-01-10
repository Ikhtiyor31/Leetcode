class Solution {
    public int strStr(String haystack, String needle) {
        
        for (int i = 0; i < haystack.length(); i++) {
            for (int j = 0, k = i; j < needle.length() && k < haystack.length(); j++, k++) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) return i;
            }
        }

        return -1;
    }
}