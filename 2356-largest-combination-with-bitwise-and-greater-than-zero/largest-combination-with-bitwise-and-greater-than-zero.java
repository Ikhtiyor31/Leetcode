class Solution {

    public int largestCombination(int[] candidates) {
        int n = candidates.length;
        int answer = 0;
        for (int i = 0; i < 24; i++) {
            int cnt = 0;
            for (int num: candidates) {
                if((num & (1 << i)) != 0) cnt++;
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
/*
 [16, 17, 71, 62, 12, 24, 14]
                   
 000000000000000000010000 
 000000000000000000010001
 000000000000000001000111
 000000000000000000111110
 000000000000000000001100
 000000000000000000011000
 000000000000000000001110
                  1144432
 
*/