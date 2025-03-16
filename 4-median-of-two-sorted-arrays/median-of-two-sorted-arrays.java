class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int t = 0;
        int i = 0;
        int j = 0;
        int index = 0;
        int[] result = new int[n + m];
        while (i < m || j < n) {
            if (i < m && j < n) {
                if (nums1[i] > nums2[j]) {
                    result[index++] = nums2[j++];
                } else {
                    result[index++] = nums1[i++];
                }
            } else if (i < m) {
                result[index++] = nums1[i++];
            } else {
                result[index++] = nums2[j++];
            }
        }
        if ((n + m) % 2 == 0) {
            return (double)(result[(n + m) / 2] + result[(n + m - 1) / 2]) / 2;
        }
        return (double)result[(n + m) / 2];
    }
}