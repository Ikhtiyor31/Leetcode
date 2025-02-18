class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        if n < k:
            return []
        de = deque()
        ans = []

        for i in range(0, n):
            if de and i - de[0] >= k:
                de.popleft()
            while de and nums[i] >= nums[de[-1]]:
                de.pop()
            de.append(i)
            if i >= k - 1:
                ans.append(nums[de[0]])

        return ans
