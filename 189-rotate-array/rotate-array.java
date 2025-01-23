class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n-i-1];
            nums[n-i-1] = temp;
        }

        for (int i = 0; i < k / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[k-i-1];
            nums[k-i-1] = temp;
        }
        int j = n - 1;
        for (int i = k; i < (n + k) / 2; i++, j--) {
            System.out.println(i);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}