class Solution:

    # use helper constant size list as a counter, if some character exists multiple times in
    # one not in the other, it will show as one of the elements in the helper list being non-zero
    # value
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        cnt = [0] * 26

        for i in range(len(s)):
            cnt[c2i(s[i])] += 1
            cnt[c2i(t[i])] -= 1
        for j in range(26):
            if cnt[j] != 0:
                return False

        return True


def c2i(c: str) -> int:
    return ord(c) - ord("a")
