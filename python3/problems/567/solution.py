from collections import Counter


class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        n, m = len(s2), len(s1)
        if m > n:
            return False

        seen = Counter(s1)
        matches = 0
        l = 0

        for r, ch in enumerate(s2):
            # not in s1 or not enough duplicates, shrink the window
            while l < r and seen.get(ch, 0) == 0:
                prev = s2[l]
                if prev in seen:
                    seen[prev] += 1
                    matches -= 1
                l += 1

            if seen.get(ch, 0) > 0:
                seen[ch] -= 1
                matches += 1

            if matches == m:
                return True

        return False
