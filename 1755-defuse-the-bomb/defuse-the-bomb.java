class Solution {
    public int[] decrypt(int[] code, int k) {
        
        int n = code.length;
        int j = k > 0 ? 0 : n - Math.abs(k) - 1;
        int i = j;
        int sum = 0;
        int t = 0;
        while (t < Math.abs(k)) {
                sum += code[j % n];
                System.out.println(code[j % n]);
                j++;
                t++;
        }
        int[] ans = new int[n];
        for (int indx = 0; indx < n; indx++) {
            sum -= code[i % n];
            sum += code[j % n];
            j++;
            i++;
            ans[indx] = sum;
        }

        return ans;
    }
}