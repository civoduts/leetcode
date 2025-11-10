BRACKET_PAIRS = {"(": ")", "{": "}", "[": "]"}
CLOSING_BRACKETS = {")", "}", "]"}


class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for ch in s:
            if ch in BRACKET_PAIRS:
                stack.append(ch)
            elif ch in CLOSING_BRACKETS:
                if not stack:
                    return False
                if BRACKET_PAIRS[stack.pop()] != ch:
                    return False
        return len(stack) == 0
