class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 0;
        long r = 100_000_000_000_000L;
        long answer = 0;
        while (l < r) {
            long m = l + (r - l) / 2;
            long total = 0;
            for (int i = 0; i < time.length; i++) {
                total += (m / time[i]);
            }
           
            if (total < totalTrips) {
                l = m  + 1;
            } else {
                r = m;
            }
        }

        return l;
    }
}