class Solution {
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            String digits = String.valueOf(i);
            int sum = 0;
            for (char c : digits.toCharArray()) {
                sum += c - '0';
            }
            if (sum <= num && sum % 2 == 0) 
                count++;
        }

        return count;
    }
}