from collections import deque


class Solution:
    def maxAreaOfIsland(self, grid: list[list[int]]) -> int:
        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        best = 0

        def bfs(r: int, c: int) -> int:
            queue = deque([(r, c)])
            grid[r][c] = 0
            size = 1

            while queue:
                row, col = queue.popleft()

                for dr, dc in dirs:
                    r, c = dr + row, dc + col

                    if min(r, c) < 0 or r >= rows or c >= cols or grid[r][c] == 0:
                        continue

                    queue.append((r, c))
                    grid[r][c] = 0
                    size += 1

            return size

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1:
                    best = max(best, bfs(r, c))

        return best
