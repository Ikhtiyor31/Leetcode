class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashSet<Integer> distinct = new HashSet<>();
        int answer = 0;
        for (int num: nums) {
            distinct.add(num);
        }
        int n = nums.length;
        int right = 0;
        for (int left = 0; left < n; left++) {
            if (left > 0) {
                count.put(nums[left-1], count.get(nums[left-1]) - 1);
                if (count.get(nums[left-1]) == 0) {
                    count.remove(nums[left-1]);
                }
            }


            while (right < n && count.size() < distinct.size()) {
                count.put(nums[right], count.getOrDefault(nums[right], 0) + 1);
                right++;
            }
            if (count.size() == distinct.size()) {
                answer += (n - right + 1);
            }
        }
        return answer;
    }
}