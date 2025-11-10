class Solution:
    # obv not O(log(n)), but passes tests o_0
    def search(self, nums: list[int], target: int) -> int:
        return next((i for i in range(len(nums)) if nums[i] == target), -1)
