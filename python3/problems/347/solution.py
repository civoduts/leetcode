import heapq

from collections import defaultdict, Counter


class Solution:
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        freqs = Counter(nums)
        inverse = defaultdict(list)
        for key, val in freqs.items():
            inverse[val].append(key)

        heap = [-key for key in inverse.keys()]
        heapq.heapify(heap)

        ret = []
        for _ in range(k):
            top = -heapq.heappop(heap)
            ret.extend(inverse[top])

            if len(ret) >= k:
                return ret[:k]
        return ret
