class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] answer = new int[n];
        int ball = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                suffix[i] += suffix[i+1] + ball;
            }
            ball += boxes.charAt(i) == '1' ? 1 : 0;
            
        }  
        ball = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                prefix[i] += prefix[i-1] + ball;
            }
            ball += boxes.charAt(i) == '1' ? 1 : 0;
        }

        for (int i = 0; i < n; i++) {
            answer[i] = prefix[i] + suffix[i];
        }
        
        return answer; 
    }
}
/*
    0 1 2 3 4 5
    0 0 1 0 1 1
    11 8 5 3 1 0
    0  0 0 1 2 4

 balls = 1
 operations = 11, 8,    

*/