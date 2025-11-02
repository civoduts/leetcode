import math


class Solution:
    def minEatingSpeed(self, piles: list[int], h: int) -> int:
        l, r = 1, max(piles)
        k_min = r
        while l <= r:
            k = (r + l) // 2
            total_time = sum(math.ceil(p / k) for p in piles)

            if total_time <= h:
                k_min = min(k_min, k)
                r = k - 1
            elif total_time > h:
                l = k + 1

        return k_min
