class Solution {
    int[][] memo;
    public int numDistinct(String s, String t, int i, int j, int cnt) {
        if (cnt == t.length() && j == t.length()) {
            return 1;
        }

        if (i >= s.length() || j >= t.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
       
        int match = 0;

        if (s.charAt(i) == t.charAt(j)) {
            match += numDistinct(s, t, i + 1, j + 1, cnt + 1);
        } 
        
        match += numDistinct(s, t, i + 1, j, cnt);
        

        return memo[i][j] = match;
    }
    public int numDistinct(String s, String t) {
        memo = new int[s.length() + 1][t.length() + 1];
        for (int[] arr: memo) {
            Arrays.fill(arr, -1);
        }
        return numDistinct(s, t, 0, 0, 0);
    }
}


/*
r = r continue
a = a 
b = b
b = b
b != i skip b
i = i
t = t


it doesn't match

*/