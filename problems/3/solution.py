class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = set()
        best = 0
        l = 0
        for r, curr in enumerate(s):
            while curr in seen:
                seen.remove(s[l])
                l += 1
            best = max(best, r - l + 1)
            seen.add(s[r])

        return best
