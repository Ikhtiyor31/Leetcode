class Solution {
    public int takeCharacters(String s, int k) {
        int a = 0, b = 0, c = 0;
        int n = s.length();
        int l = 0;
        int ans = 0;
     
        for (int i = 0; i < n; i++) {
            a += s.charAt(i) == 'a' ? 1 : 0;
            b += s.charAt(i) == 'b' ? 1 : 0;
            c += s.charAt(i) == 'c' ? 1 : 0;
        }
        if (a < k || b < k || c < k) {
            return -1;
        }
        int currA = 0;
        int currB = 0;
        int currC = 0;

        for (int i = 0; i < n; i++) {
            currA += s.charAt(i) == 'a' ? 1 : 0;
            currB += s.charAt(i) == 'b' ? 1 : 0;
            currC += s.charAt(i) == 'c' ? 1 : 0;

             while (l <= i && (a - currA < k || b - currB < k || c - currC  < k)) {
                currA -= s.charAt(l) == 'a' ? 1 : 0;
                currB -= s.charAt(l) == 'b' ? 1 : 0;
                currC -= s.charAt(l) == 'c' ? 1 : 0;
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }

        return n - ans;
    }
}