class Solution {
    public String formString(int n) {
        if (n == 1) {
            return "0";
        }

        String form = formString(n-1);
        
        return form + "1" + reverse(invert(form));
    }

      public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(n - i - 1));
            sb.setCharAt(n - i - 1, c);   
        }

        return sb.toString();
    }

    public String invert(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            sb.setCharAt(i, sb.charAt(i) == '0'? '1' : '0');
        }

        return sb.toString();
    }
    public char findKthBit(int n, int k) {
        
        return formString(n).charAt(k-1);
    }
}