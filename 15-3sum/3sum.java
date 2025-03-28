class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i-1] == nums[i])
                continue;
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int target = nums[l] + nums[i] + nums[r];
                if (target == 0) {
                    answer.add(new ArrayList<>(Arrays.asList(nums[l++], nums[i], nums[r--])));
                    while (l < n - 1 && nums[l-1] == nums[l]) {
                        l++;
                    }
                    while (l < r && nums[r + 1] == nums[r]) {
                        r -= 1;
                    }
                } else if (target > 0) {
                    r -= 1;
                } else {
                    l += 1;
                }
            }
        }
        return answer;
    }
}