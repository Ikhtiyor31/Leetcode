class Solution {
    public int minimumDeletions(String s) {
      
        int n = s.length();
        int[] preProcessB = new int[n];
        int[] preProcessA = new int[n];
      
        for (int i = 0; i < n; i++) {
            preProcessB[i] = preProcessB[i == 0 ? i : i - 1] + (s.charAt(i) == 'b' ? 1 : 0);
          
        }
      
 
        for (int i = n - 1; i >= 0; i--) {
            preProcessA[i] = preProcessA[i == n - 1 ? i : i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
          
        }

        int count = n;
        for (int i = 0; i < n; i++) {
            count = Math.min(count, preProcessA[i] + preProcessB[i]);
        }
      

        return count-1;
    }
}

/*
a a b a b b a b
1 2 2 3 3 3 4 4
4 4 4 3 3 2 1 1


b b a a a a a b b
0 0 1 2 3 4 5 5 5
4 3 2 2 2 2 2 2 1
 */