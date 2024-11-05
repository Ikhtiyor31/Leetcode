class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int cnt = 1;
        int minChange = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                cnt++;
                continue;
            }

            if (cnt % 2 != 0) {
                 minChange++;
                 cnt = 0;
            } else {
                cnt = 1;
            } 
           
        }

        return minChange;
    }
}