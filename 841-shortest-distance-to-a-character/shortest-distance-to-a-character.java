class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int distance = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                distance = i;
                break;
            }
        }

        int[] result = new int[s.length()];
        for (int i = 0; i < n; i++) {
            if (c == s.charAt(i)) {
                distance = i;
            }
            result[i] = Math.abs(distance - i);
        }
        

        for (int i = n - 1; i >= 0; i--) {
            if (c == s.charAt(i)) {
                distance = i;
            }
            result[i] = Math.min(result[i], Math.abs(distance - i));
        }

        return result;
    }
}