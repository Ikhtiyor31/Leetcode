class Solution {
    public boolean isVowel(char c) {
        return 'a' == c || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'O' || c == 'A' || c == 'E' || c == 'I' || c == 'U' || c == 'A';
    }
    public String reverseVowels(String s) {
        
        int n = s.length();
    
        int l = 0;
        int r = n - 1;
        StringBuilder sb = new StringBuilder(s);
        while (l < r) {
            if (!isVowel(sb.charAt(l))) {
                l++;
                continue;
            }
            if (!isVowel(sb.charAt(r))) {
                r -= 1;
                continue;
            }
            System.out.println(l + " " + r);
            char t = sb.charAt(l);
            sb.setCharAt(l, sb.charAt(r));
            sb.setCharAt(r, t);
            r--;
            l++;
        }

        return sb.toString();
    }
}