class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i-1] == nums[i])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j-1] == nums[j]) 
                    continue;
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        answer.add(temp);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l-1] && nums[r] == nums[r+1]) {
                            l++;
                            r--;
                        }
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                   
                }
            }
        }

        return answer;
    }
}