class Solution {
    public int possibleStringCount(String word) {
        int length = word.length();
        int count = 1;
        int answer = 1;
        for (int i = 1; i < length; i++) {
            if (word.charAt(i-1) == word.charAt(i)) {
                count += 1;
            } else {
                if (count > 1) {
                    answer += count - 1;
                }
                count = 1;
            }
            
        }

        if (count > 1) {
            answer += count - 1;
        }

        return answer;
    }
}