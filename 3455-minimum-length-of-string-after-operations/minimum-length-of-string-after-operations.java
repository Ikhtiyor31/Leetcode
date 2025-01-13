class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        int len = n;
        boolean[] deleted = new boolean[n];
        
        for (int i = 1; i < n; i++)  {
            int l = i - 1;
            int r = i + 1;
            if (deleted[i]) continue;
            boolean leftFound = false;
            while (l >= 0) {
                if (!deleted[l] && s.charAt(i) == s.charAt(l)) {
                    leftFound = true;
                    break;
                }
                l--;
            }
            boolean rightFound = false;
            while (r < n) {
                 if (!deleted[r] && s.charAt(i) == s.charAt(r)) {
                    rightFound = true;
                    break;
                }
                r++;
            }

            if (leftFound && rightFound) {
                deleted[l] = true;
                deleted[r] = true;
                len -= 2;
            }
        }

        return len;
    }
}