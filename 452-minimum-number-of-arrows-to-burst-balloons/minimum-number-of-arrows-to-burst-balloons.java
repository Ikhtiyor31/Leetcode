class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        System.out.println(Arrays.deepToString(points));
        int n = points.length;
        int l = 0;
        int r = 1;
        int count = 1;
        while (r < n) {
            if (points[l][1] >= points[r][0]) {
                r++;
            } else {
                count++;
                l = r;
                r++;
            }
        }

        return count;
    }
}
// [[1,6], [2,8], [7,12], [10,16]]

// 