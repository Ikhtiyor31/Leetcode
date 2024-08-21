class Solution {
    public int hIndex(int[] citations) {
        
        Arrays.sort(citations);

        int count = 0;
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
        return n-l;
    }
}