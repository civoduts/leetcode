from collections import Counter


class Solution:
    # braindead, but works; Counter will create (internally) a dict structure, where it
    # will count occurences of hashable objects from a provided iterable object
    def isAnagram(self, s: str, t: str) -> bool:
        return Counter(s) == Counter(t)
