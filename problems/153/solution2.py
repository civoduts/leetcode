class Solution:
    def findMin(self, nums: list[int]) -> int:
        l, r = 0, len(nums) - 1
        best = float("inf")
        while l < r:
            mid = l + (r - l) // 2
            if nums[mid] >= nums[l]:
                best = min(best, nums[l])
                l = mid + 1
            else:
                r = mid
        return min(nums[l], best)
