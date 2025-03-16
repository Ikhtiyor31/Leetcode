class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long l = 1;
        long r = (long)Arrays.stream(ranks).min().getAsInt() * cars * cars;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long target = 0;
            for (int i = 0; i < n; i++) {
                target += Math.sqrt((mid / ranks[i]));
            }
            if (target >= cars) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
        
    }
}

/*
[1, 2, 3, 4], cars = 10 -> 6
 1  1  1  1
 2  2  1  1



 [1, 5, 8, 9] cars = 6
  1  1  1  1
*/