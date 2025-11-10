class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        def _i(ch: str) -> int:
            return ord(ch) - ord("a")

        m, n = len(s1), len(s2)
        if m > n:
            return False

        N = 26

        count1 = [0] * N
        count2 = [0] * N
        matches = 0

        # first window
        for i in range(m):
            count1[_i(s1[i])] += 1
            count2[_i(s2[i])] += 1

        # how many matches in the first window?
        for i in range(N):
            matches += 1 if count1[i] == count2[i] else 0
        if matches == N:
            return True

        for i in range(m, n):
            prev, next_ = _i(s2[i - m]), _i(s2[i])

            if count1[prev] == count2[prev]:  # before
                matches += -1
            elif count1[prev] == (count2[prev] - 1):  # after
                matches += 1
            count2[prev] -= 1

            if count1[next_] == count2[next_]:  # before
                matches += -1
            elif count1[next_] == (count2[next_] + 1):  # after
                matches += 1
            count2[next_] += 1

            if matches == N:
                return True

        return False
