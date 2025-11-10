class Solution:
    # sort, then linearly compare both strings; if interviewer asks for O(1) space complexity, 
    # sorting can (internally) use O(n) of space therefore this solution would not be accepted
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        s1 = sorted(s)
        s2 = sorted(t)

        return s1 == s2