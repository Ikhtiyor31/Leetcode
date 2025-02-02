class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        int n = time.length;
        int sum = Arrays.stream(time).max().getAsInt();
        long l = 0;
        long r = 100_000_000_000_000L;
        //System.out.println(r);
        long ans = 0;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long count = 0;
            for (int i = 0; i < n; i++) {
                count += (m / time[i]);
            }
            //System.out.println(count + " " + m);
            if (count >= totalTrips) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
} 
/*

3/1
9, 2
9  4
*/