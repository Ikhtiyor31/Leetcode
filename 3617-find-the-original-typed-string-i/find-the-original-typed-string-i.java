class Solution {
    public int possibleStringCount(String word) {
        int length = word.length();
        int answer = 1;
        for (int i = 1; i < length; i++) {
            if (word.charAt(i-1) == word.charAt(i)) {
                answer += 1;
            } 
        }

        return answer;
    }
}