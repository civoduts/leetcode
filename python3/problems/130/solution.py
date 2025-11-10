from collections import deque


class Solution:
    def solve(self, board: list[list[str]]) -> None:
        if not board or not board[0]:
            return
        rows, cols = len(board), len(board[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        all_captureable = set()
        touching_edges = set()

        for r in range(rows):
            for c in range(cols):
                if board[r][c] != "O":
                    continue
                all_captureable.add((r, c))
                if r == 0 or r == rows - 1 or c == 0 or c == cols - 1:
                    touching_edges.add((r, c))

        def bfs(seen: set[tuple[int, int]]) -> set[tuple[int, int]]:
            queue = deque(seen)

            while queue:
                for _ in range(len(queue)):
                    r, c = queue.popleft()

                    for dr, dc in dirs:
                        rr = r + dr
                        cc = c + dc

                        if (
                            not (0 <= rr <= rows - 1 and 0 <= cc <= cols - 1)
                            or (rr, cc) in seen
                            or board[rr][cc] != "O"
                        ):
                            continue

                        seen.add((rr, cc))
                        queue.append((rr, cc))

            return seen

        for r, c in all_captureable - bfs(touching_edges):
            board[r][c] = "X"
