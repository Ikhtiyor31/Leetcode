class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int r = n - 1;
        while (r > 0 && arr[r-1] <= arr[r]) {
            r--;
        }

        int ans = r;
        int l = 0;
        while (l < r && (l == 0 || arr[l-1] <= arr[l])) {
            while (r < n && arr[l] > arr[r]) {
                r++;
            }
           
            ans = Math.min(ans, r - l - 1);
            l++;
        }


        return ans;
    }
}