class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int x = Arrays.stream(quantities).max().getAsInt();
        int maxAmount = 0;
        int l = 1;
        int r = x;
        int ret = 0;
        while (l <= r) {
            int ans = l + (r - l) / 2;
            int count = 0;
            for (int quantity: quantities) {
                
                int div = (int) Math.floor(quantity / ans);
                count += div + Math.ceil((double) (quantity % ans) / ans);
            }
         
            if (count <= n) {
                ret = ans;
                r = ans - 1;
            } else  {
                l = ans + 1;
            }
        }

        return ret;
    }
}

/*
n = 7, quantities = [15, 10, 10]
x 


*/