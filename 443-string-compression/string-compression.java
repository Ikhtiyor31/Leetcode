class Solution {
    public int compress(char[] chars) {
        int cnt = 1;
        int idx = 0;
        int n = chars.length;
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i-1]) {
                cnt++;
            } else {
                chars[idx++] = chars[i-1]; 
                if (cnt > 1) {
                    if (cnt >= 10) {
                        String str = String.valueOf(cnt);
                        for (char c: str.toCharArray()) {
                            chars[idx++] = c;
                        }
                    } else {
                        chars[idx++] = (char)(cnt + '0');
                    }
                }
                cnt = 1;
            }
        }   
        chars[idx++] = chars[n - 1];

        if (cnt > 1) {
            if (cnt >= 10) {
                String str = String.valueOf(cnt);
                for (char c: str.toCharArray()) {
                    chars[idx++] = c;
                }
            } else {
                chars[idx++] = (char)(cnt + '0');
            }
        }
        return idx;
    }

}