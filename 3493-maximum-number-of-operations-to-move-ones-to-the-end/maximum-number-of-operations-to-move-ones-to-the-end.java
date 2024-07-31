class Solution {
    public int maxOperations(String s) {
        int n = s.length();
        int res = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += s.charAt(i) - '0';
            if (i > 0 && s.charAt(i- 1) == '1' && s.charAt(i) == '0') {
                res += cnt;
            }
        }

        return res;
    }
}