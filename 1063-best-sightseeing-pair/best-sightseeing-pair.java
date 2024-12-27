class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        
        int n = values.length;
        int maxScore = 0;
        int i = 0;
        int j = 1;
        int lastMax = values[i];
        while (j < n) {

            maxScore = Math.max(maxScore, values[i] + values[j] + (i - j));

            if (values[i] < values[j] + (j - i)) {
                i = j;
            }
            j++;
        }

        return maxScore;
    }
}
/*
    0  1  2  3  4
// [8, 1, 5, 2, 6]

1 3 2 4 0
1 2 5 6 8

 0  1  2   3  4  5   6  7
[6, 9, 10, 5, 9, 10, 4, 5]

6 3 7 0 1 4 2  5
4 5 5 6 9 9 10 10
*/