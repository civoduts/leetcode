import heapq

from collections import Counter


class Solution:
    # cleaner solution using Counter to form frequency; heap is formed by a priority such that
    # we "abuse" the fact that if a tuple of two elements is added, first element is "understood" by
    # the heapq API as a value based on which the heap will be form, we can quickly form a heap
    # of tuples where first element is frequency of occurence and second the value from the `nums`
    # list. from docs: https://docs.python.org/3/library/heapq.html#basic-examples
    # note: in python, mean-heap is the implementation
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        freqs = Counter(nums)
        heap = [(-count, num) for num, count in freqs.items()]
        heapq.heapify(heap)

        ret = []
        for _ in range(k):
            _, top = heapq.heappop(heap)
            ret.append(top)

            if len(ret) == k:
                return ret
        return ret
