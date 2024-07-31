class Solution {
    public int minimumDeletions(String s) {
      
        int n = s.length();
        int preProcessB = 0;
        int preProcessA = 0;
      

 
        for (int i = n - 1; i >= 0; i--) {
            preProcessA += (s.charAt(i) == 'a' ? 1 : 0);
        }

        int count = n;
        for (int i = 0; i < n; i++) {
            preProcessA -= (s.charAt(i) == 'a' ? 1 : 0);
            count = Math.min(count, preProcessA + preProcessB);
            preProcessB += (s.charAt(i) == 'b' ? 1 : 0);
        }
      

        return count;
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