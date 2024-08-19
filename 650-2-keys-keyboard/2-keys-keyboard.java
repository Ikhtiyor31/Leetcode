class Solution {
    int[][] memo;
    public int minSteps(int n, int currLen, int pasteLen) {
        if (currLen == n)
            return 0;

        if (currLen > n) 
            return 1000;
        if (memo[currLen][pasteLen] != 0) 
            return memo[currLen][pasteLen];
        int first = 2 + minSteps(n, 2 * currLen, currLen);
        int second = 1 + minSteps(n, currLen + pasteLen, pasteLen);
        memo[currLen][pasteLen] = Math.min(first, second);
        return Math.min(first, second);
    }

    public int minSteps(int n) {
        memo = new int[n + 1][n / 2 + 1];
        if (n == 1) {
            return 0;
        }
        return 1 + minSteps(n, 1, 1);
    }
}
/*
5 
    'A' 1 copy
    'A''A' 2 paste
    'A''A' 3 copy
    'A''A''A''A'
*/