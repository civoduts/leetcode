class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        n = len(nums)
        prefix = [1] * n
        suffix = [1] * n

        for i in range(1, n):
            prefix[i] *= prefix[i - 1] * nums[i - 1]
            suffix[n - 1 - i] *= suffix[n - i] * nums[n - i]

        return [prefix[i] * suffix[i] for i in range(n)]
