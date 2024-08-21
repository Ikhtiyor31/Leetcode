class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        int l = 0;
        int h = n-1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (citations[mid] >= n-mid) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(n - l);
        return n-l;
    }
}