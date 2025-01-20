class Solution {
    public String makeGood(String s) {
       
        int n = s.length();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder(s);
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - 1) && (s.charAt(j) == Character.toLowerCase(s.charAt(j - 1)) || s.charAt(j-1) == Character.toLowerCase(s.charAt(j)))) {
                    sb.deleteCharAt(j);
                    sb.deleteCharAt(j - 1);
                    break;
                }
            }
            s = sb.toString();
        }

        return s;
    }
}