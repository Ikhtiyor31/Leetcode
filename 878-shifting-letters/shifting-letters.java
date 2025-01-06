class Solution {
    public String shiftingLetters(String s, int[] shifts) {

        int sum = 0;
        int[] prefix = new int[shifts.length];
        for (int shift: shifts) {
            sum = (sum + shift) % 26;
           
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = (int)(s.charAt(i) - 'a');
            char shifted = (char)((sum + index) % 26 + 97);
            sb.append(shifted);
            sum = ((sum - shifts[i]) % 26 + 26) % 26;
        }

        return sb.toString();
    }
}