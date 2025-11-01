from collections import defaultdict


# Might seem like it is required to re-scan the `frequencies` table for the shrinking logic, but
# this algorithm is greedily sacrificing local correctness for a global solution.
# Explanation: `max_freq` might become stale once the current sliding window does not meet the
# condition of having at most k "other" characters that we can flip into the most
# frequenst characters in the substring. This does not matter, because the more the window expands
# and the more the most frequent character count increases, the `max_freq` increases and with it
# obviously the sliding window (r - l + 1) but the difference between these two values stays
# the same. This is what we want. At some point we might start getting a lot of "other" characters
# so much so that we need to shrink. And they keep getting added as right pointer progresses.
# Then they might become the new "max_freq", meaning the new most frequent character is from the
# "others" bunch. This is what we care about, because now the difference of `window size` and
# `max frequency` becomes constant, but the window size still grows and with it potentially the new
# best.
# For example: we can have 100 A's, 2 B's, and a 1 C with k = 3. Once we hit a new non-A character,
# this window needs shrinking. If we shrink by one, the condition of `window size` - `max freq.` is
# satisfied, even though technically this is not the correct window. We do not care, because this
# window can never be bigger than the previous biggest one (100 A, 2 B, 1 C) = 103. The more non-A
# characters are added, the more we need to shrink. At some point let's say so many B's are added,
# that they become the new most frequent character. For example (99 B, 1 A, 1 C) = 102. 
# Adding 2 more B's, the new `max_freq` is now 101. Which is true. And with it, the new best is also
# 104. So from this explanation we notice that we really just care about sliding windows that are
# bigger than the last time and it does not even matter if our window is incorrect in other cases,
# as we will only count the window size that exceeds our previous best. That will only happen once
# the `max_freq` increases, and with `max_freq` increase the `window size` also increases and we
# can record this window as the new best.

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        freqs = defaultdict(int)
        max_freq = 0
        best = 0
        l = 0

        for r, ch in enumerate(s):
            freqs[ch] += 1
            max_freq = max(max_freq, freqs[ch])

            while ((r - l + 1) - max_freq) > k:
                freqs[s[l]] -= 1
                l += 1

            best = max(best, r - l + 1)

        return best
