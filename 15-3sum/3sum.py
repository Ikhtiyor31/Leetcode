class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()

        n = len(nums)
        answer = []
        for i, num in enumerate(nums):
            if i > 0 and nums[i - 1] == num:
                continue
            l = i + 1
            r = n - 1
            while l < r:
                sum = num + nums[l] + nums[r]
                if sum == 0:
                    answer.append([num, nums[l], nums[r]])
                    while l < n - 1 and nums[l] == nums[l + 1]:
                        l += 1
                    while r > 0 and nums[r - 1] == nums[r]:
                        r -= 1
                    l += 1
                    r -= 1
                elif sum > 0:
                    r -= 1
                else:
                    l += 1

        return answer
