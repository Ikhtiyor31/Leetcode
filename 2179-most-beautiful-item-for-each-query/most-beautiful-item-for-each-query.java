class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return a[0] - b[0];
        });

        //System.out.println(Arrays.deepToString(items));
        int n = items.length;
    
        System.out.println(Arrays.deepToString(items));
        int[] ans = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        int maxBeauty = 0;
        for (int[] item: items) {
           maxBeauty = Math.max(maxBeauty, item[1]);
           item[1] = maxBeauty;
        }
        int i = 0;
        for (int query: queries) {
            int l = 0;
            int r = items.length - 1;
            maxBeauty = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (query < items[mid][0]) {
                    r = mid - 1;
                } else {
                    maxBeauty = Math.max(maxBeauty, items[mid][1]);
                    l = mid + 1;
                }
                
            }
            ans[i++] = maxBeauty;
        }
        return ans;
    }
}

/*
[[1,2],[2,4],[3,5],[3,2],[5,6]], queries = [1,2,3,4,5,6]


*/