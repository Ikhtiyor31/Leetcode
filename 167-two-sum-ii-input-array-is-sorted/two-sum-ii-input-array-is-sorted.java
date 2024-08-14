class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int want = target - numbers[i];

            int low = 0;
            int high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (numbers[mid] == want && mid != i) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > want) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return new int[]{-1, -1};
    }
}