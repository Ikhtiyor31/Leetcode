class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] leftLongest = new int[n];
        for (int i = 0; i < n; i++) {
            leftLongest[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    leftLongest[i] = Math.max(leftLongest[i], leftLongest[j] + 1);
                }
            }
             System.out.print(leftLongest[i] + " ");
        }
        System.out.println();

        int[] rightLongest = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            rightLongest[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    rightLongest[i] = Math.max(rightLongest[i], rightLongest[j] + 1);
                }
            }
            System.out.print(rightLongest[i] + " ");
        }

        int maxLength = 0;
        for (int i = 1; i < n-1; i++) {
            if (leftLongest[i] > 1 && rightLongest[i] > 1)
            maxLength = Math.max(maxLength, leftLongest[i] + rightLongest[i] - 1);
        }

        return n - maxLength;
    }
}