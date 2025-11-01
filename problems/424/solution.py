from collections import defaultdict


class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        best = 0
        freqs = defaultdict(int)
        max_freq = 0
        l = 0

        for r, ch in enumerate(s):
            freqs[ch] += 1
            max_freq = max(max_freq, freqs[ch])

            # have we overshot the window? shrink it
            while ((r - l + 1) - max_freq) > k:
                freqs[s[l]] -= 1
                l += 1
                max_freq = max(freqs.values())

            if (r - l + 1) > best:
                best = r - l + 1

        return best
