class Solution:
    def isPalindrome(self, s: str) -> bool:
        new_s = [c for c in s.lower() if c.isalnum()]

        return new_s == new_s[::-1]