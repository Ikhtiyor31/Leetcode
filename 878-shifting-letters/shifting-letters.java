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
            long ascii = sum % 26;
            System.out.println(ascii);
            if (s.charAt(i) + ascii > 122) {
                long ascii2 = ((s.charAt(i) + ascii) % 122);
                sb.append((char) (96 + ascii2));
            } else {
                sb.append((char)(s.charAt(i) + ascii));
            }
            
        }

        return sb.toString();
    }
}