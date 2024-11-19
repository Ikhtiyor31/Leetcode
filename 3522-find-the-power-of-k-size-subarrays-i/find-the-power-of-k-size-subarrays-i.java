class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            if (deque.isEmpty()) {
                deque.add(nums[i]);
            } else {
                if (deque.getLast() + 1 != nums[i]) {
                    deque.clear();
                    deque.add(nums[i]);
                } else {
                    deque.add(nums[i]);
                }
            }
        }
        int j = 0;
        if (deque.size() == k) {
            ans[j++] = deque.getLast();
        } else {
            ans[j++] = -1;
        }

        for (int i = k; i < n; i++) {
            if (deque.getLast() + 1 == nums[i]) {
                deque.add(nums[i]);
            } else {
                while (!deque.isEmpty()) {
                    deque.pop();
                }
                deque.add(nums[i]);
            }
            if (deque.size() > k) {
                deque.removeFirst();
            }
            if (deque.size() == k) {
                ans[j++] = deque.getLast();
            } else {
                ans[j++] = -1;
            }
        }
        
        return ans;
    }
}