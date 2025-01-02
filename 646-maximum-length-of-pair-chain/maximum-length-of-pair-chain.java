class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        
        int n = pairs.length;
        int[] dp = new int[n];
        int l = 0;
        int count = 1;
        for (int i = 1; i < n; i++) {
            System.out.print(Arrays.toString(pairs[i]));
            if (pairs[i][0] > pairs[l][1]) {
                count++;
                l = i;
            }
        }


        return count;
    }
}