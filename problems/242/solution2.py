class Solution:
    # use dict to count occurences of each character
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        cnt = dict()
        for i in range(len(s)):
            cnt[s[i]] = 1 + cnt.get(s[i], 0)
            cnt[t[i]] = -1 + cnt.get(t[i], 0)

        for _, v in cnt.items():
            if v > 0:
                return False

        return True
