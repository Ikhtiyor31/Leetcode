class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        n = len(nums)
        right = -1
        for i in range(n-2, -1, -1):
            if nums[i] < nums[i+1]:
                right = i  
                break  
        print(right)
        if right == -1:
            for i in range(0, int(n / 2)):
                nums[i], nums[n-i-1] = nums[n-i-1], nums[i]
            return

        index = right + 1
        for i in range(n - 1, right, -1):
            if nums[i] > nums[right]:
                index = i
                break
        
        nums[right], nums[index] = nums[index], nums[right]
        nums[right + 1:] = reversed(nums[right + 1:])
        
        