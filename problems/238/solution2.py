class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        n = len(nums)
        answer = [1] * n

        prefix = 1
        for i in range(1, n):
            prefix *= nums[i - 1]
            answer[i] = prefix

        suffix = 1
        for j in range(n - 2, -1, -1):
            suffix *= nums[j + 1]
            answer[j] *= suffix

        return answer
