def dfs(
    ans: list[str],
    seq: str,
    opens: int,
    closes: int,
    n: int,
) -> None:
    # goal
    if opens + closes == 2 * n:
        ans.append(seq)
        return
    
    # constraints
    if opens < n:
        # choice 
        dfs(ans, seq + "(", opens + 1, closes, n)
    if closes < opens:
        # choice 
        dfs(ans, seq + ")", opens, closes + 1, n)

# backtracking
class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        ans = []

        dfs(ans, "", 0, 0, n)
        return ans
