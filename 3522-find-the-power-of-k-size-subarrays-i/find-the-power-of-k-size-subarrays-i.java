class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int counter = 0;
        for (int i = 0; i < k ; i++) {
            if (i == 0) {
                counter = 1;
            } else {
                if (nums[i - 1] + 1 != nums[i]) {
                    counter = 1;
                } else {
                    counter += 1;
                }
            }
        }
        int j = 0;
        if (counter == k) {
            ans[j++] = nums[k-1];
        } else {
            ans[j++] = -1;
        }

        for (int i = k; i < n; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                counter++;
            } else {
                counter = 1;
            }
            if (counter > k) {
                counter--;
            }
            if (counter == k) {
                ans[j++] = nums[i];
            } else {
                ans[j++] = -1;
            }
        }
        
        return ans;
    }
}