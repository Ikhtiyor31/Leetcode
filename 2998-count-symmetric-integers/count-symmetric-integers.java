class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int answer = 0;
        for (int x = low; x <= high; x++) {
            String str = String.valueOf(x);
            if (str.length() % 2 == 1) continue;
            String first = str.substring(0, str.length() / 2);
            String last = str.substring(str.length() / 2, str.length());
            int firstSum = first.chars()
                .map(Character::getNumericValue)
                .sum();
            int lastSum = last.chars()
                .map(Character::getNumericValue)
                .sum();
            if (firstSum == lastSum) {
                answer += 1;
            }
        }

        return answer;
        
    }
}