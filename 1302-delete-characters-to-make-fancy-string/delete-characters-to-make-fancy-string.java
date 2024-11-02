class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i) && cnt < 2) {
                ans.append(s.charAt(i));
                cnt++;
            } else if (s.charAt(i-1) == s.charAt(i)) {
                continue;
            } else {
                ans.append(s.charAt(i));
                cnt = 1;
            }
        }

        return ans.toString();
    }
}