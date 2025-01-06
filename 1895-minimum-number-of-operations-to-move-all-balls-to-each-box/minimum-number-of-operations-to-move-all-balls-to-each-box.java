class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (boxes.charAt(j) == '1')
                    answer[i] += (i - j);
            }

            for (int j = i + 1; j < n; j++) {
                if (boxes.charAt(j) == '1')
                    answer[i] += (j - i);
            }
        }  

        return answer; 
    }
}