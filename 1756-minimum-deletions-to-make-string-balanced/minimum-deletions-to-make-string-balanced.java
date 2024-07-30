class Solution {
    public int minimumDeletions(String s) {
      
        int n = s.length();
        int[] preProcessB = new int[n];
        int[] preProcessA = new int[n];
        boolean aExist = false;
        for (int i = 0; i < n; i++) {
            preProcessA[i] = preProcessA[i == 0 ? i : i - 1] + (s.charAt(i) == 'a' ? 1 : 0);
            if (preProcessA[i] >= 1) aExist = true;
        }
        boolean bExist = false;
        System.out.println(n);
        for (int i = n - 1; i >= 0; i--) {
            preProcessB[i] = preProcessB[i == n - 1 ? i : i + 1] + (s.charAt(i) == 'b' ? 1 : 0);
            if (preProcessB[i] >= 1) bExist = true;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                count = Math.max(count, preProcessA[i]);
            } else {
                count = Math.max(count, Math.max(preProcessA[i] + preProcessB[i + 1], preProcessB[i]));
            }
        }
        if (!aExist || !bExist) return 0;

        return n - count;
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