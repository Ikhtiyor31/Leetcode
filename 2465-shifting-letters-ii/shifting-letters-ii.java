class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] prefix = new int[s.length() + 1];
        // sweep line
        for (int[] shift: shifts) {
            if (shift[2] == 1) {
                prefix[shift[0]] += 1;
                prefix[shift[1] + 1] -=1;
            } else {
                prefix[shift[0]] -= 1;
                prefix[shift[1] + 1] +=1;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            prefix[i] += prefix[i-1];
        }

        //System.out.println(Arrays.toString(prefix));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (prefix[i] > 0) {
                sb.append((char)((index + prefix[i]) % 26 + 97));
            } else if (prefix[i] < 0) {
                sb.append((char)((((index + prefix[i]) % 26) + 26) % 26 + 97));
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}