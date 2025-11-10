class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        # let's assume `target = a + b`
        # `a` is the current number when iterating over `nums`
        # does `b = target - a` exist within nums?

        pos = dict()
        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in pos:
                return [pos[diff], i]
            pos[nums[i]] = i
        return [-1, -1]
