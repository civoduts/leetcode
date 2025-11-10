class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        uniq = set(nums)
        longest = 0

        for n in uniq:
            if n - 1 in uniq:
                continue
            current = 1
            while n + current in uniq:
                current += 1
            if current > longest:
                longest = current

        return longest
