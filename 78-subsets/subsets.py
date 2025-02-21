class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        answer = []
        temp = []
        answer.append(temp)
        def backtrack(nums: List[int], temp: List[int], curr: int) -> None:
            
            if curr >= len(nums):
                return
            
            for i in range(curr, len(nums)):
                temp.append(nums[i])
                answer.append(temp.copy())
                backtrack(nums, temp, i + 1)
                temp.pop()

        backtrack(nums, temp, 0)

        return answer