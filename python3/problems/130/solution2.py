from collections import deque


class Solution:
    def solve(self, board: list[list[str]]) -> None:
        if not board or not board[0]:
            return
        rows, cols = len(board), len(board[0])

        queue = deque()

        def flip(r: int, c: int) -> None:
            if 0 <= r < rows and 0 <= c < cols and board[r][c] == "O":
                board[r][c] = "#"
                queue.append((r, c))

        for r in range(rows):
            flip(r, 0)
            flip(r, cols - 1)
        for c in range(cols):
            flip(0, c)
            flip(rows - 1, c)

        while queue:
            r, c = queue.popleft()
            flip(r + 1, c)
            flip(r - 1, c)
            flip(r, c + 1)
            flip(r, c - 1)

        for r in range(rows):
            for c in range(cols):
                if board[r][c] == "O":
                    board[r][c] = "X"
                elif board[r][c] == "#":
                    board[r][c] = "O"
