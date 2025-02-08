class Solution:
    def maxArea(self, heights: List[int]) -> int:
        n = len(heights)
        l = 0
        r = n - 1
        largest_container = 0
        while l < r:
            largest_container = max(
                largest_container, min(heights[l], heights[r]) * (r - l)
            )
            if heights[l] < heights[r]:
                l += 1
            else:
                r -= 1
        return largest_container
