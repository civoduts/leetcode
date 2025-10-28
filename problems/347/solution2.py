from collections import Counter


class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        freqs = Counter(nums)
        buckets = [[] for n in range(len(nums) + 1)]

        for num, count in freqs.items():
            buckets[count].append(num)

        ret = []
        for c in range(len(buckets), 0, -1):
            for n in buckets[c]:
                ret.append(n)
                if len(ret) == k:
                    return ret
        return ret
