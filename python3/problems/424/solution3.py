class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        def atoi(ch: str) -> int:
            return ord(ch) - ord("A")

        n = len(s)
        if n <= 1:
            return n
        if k >= n:
            return n

        best = 1
        counts = [0] * 26

        for i in range(n):
            if (n - i) <= best:
                break

            for c in range(26):
                counts[c] = 0

            max_freq = 0
            for j in range(i, n):
                indx = atoi(s[j])
                counts[indx] += 1
                max_freq = max(max_freq, counts[indx])
                window_size = j - i + 1
                if window_size - max_freq > k:
                    break
                best = max(best, window_size)

        return best
