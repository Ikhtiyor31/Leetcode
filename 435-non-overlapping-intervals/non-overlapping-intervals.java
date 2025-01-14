class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        System.out.println(Arrays.deepToString(intervals));
        int count = 0;
        int l = 0;
        int r = 1;
        int n = intervals.length;
        while (r < n) {
            if (intervals[l][1] > intervals[r][0]) {
                count++;
            } else {
                l = r;
            }
            r++;

        }

        return count;
    }
}

/*
[[1,2],[1,3],[2,3],[3,4]]




*/