class Solution {
    public String shiftingLetters(String s, int[] shifts) {

        int sum = 0;
        int[] prefix = new int[shifts.length];
        for (int i = shifts.length - 1; i >= 0; i--) {
            sum += shifts[i];
            sum %= 26;
            prefix[i] = sum;
           
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sum = prefix[i];
            int ascii = (int)(s.charAt(i) - 'a');
            int shifted = (sum + ascii) % 26;
            sb.append((char)('a' + shifted));
            
            
        }

        return sb.toString();
    }
}