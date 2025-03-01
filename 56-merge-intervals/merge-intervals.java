class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        int l = 0;
        int r = 1;
        list.add(new int[]{intervals[l][0], intervals[l][1]});
        while (r < n) {
            if (list.get(list.size()-1)[1] >= intervals[r][0]) {
                list.set(list.size() - 1, new int[]{intervals[l][0], Math.max(list.get(list.size()-1)[1], intervals[r][1])});
                r += 1;
            } else {
                list.add(new int[]{intervals[r][0], intervals[r][1]});
                l = r;
                r++;
            }
        }
       
        int[][] answer = new int[list.size()][2];
        int i = 0;
        for (int[] interval: list) {
            answer[i] = interval;
            i++;
        }
        return answer;
    }
}