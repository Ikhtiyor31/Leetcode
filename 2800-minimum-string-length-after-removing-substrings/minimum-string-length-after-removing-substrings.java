class Solution {
    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            if (s.indexOf("AB") != -1) {
                s = s.replace("AB", "");
            } else if (s.indexOf("CD") != -1) {
                s = s.replace("CD", "");
            }
        }

        return s.length();
    }
}