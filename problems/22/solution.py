def dfs(
    ans: list[str],
    buff: list[str],
    opens: int,
    closes: int,
    n: int,
) -> None:
    # goal
    if opens + closes == 2 * n:
        ans.append("".join(buff))
        return

    # constraints
    if opens < n:
        # choice
        buff.append("(")
        dfs(ans, buff, opens + 1, closes, n)
        buff.pop()
    if closes < opens:
        # choice
        buff.append(")")
        dfs(ans, buff, opens, closes + 1, n)
        buff.pop()


# backtracking
class Solution:
    def generateParenthesis(self, n: int) -> list[str]:
        ans = []
        buff = []

        dfs(ans, buff, 0, 0, n)
        return ans
