from collections import deque


class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        if not grid:
            return 0
        rows, cols = len(grid), len(grid[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def bfs(r: int, c: int) -> bool:
            queue = deque([(r, c)])
            grid[r][c] = "0"

            while queue:
                row, col = queue.popleft()

                for dr, dc in dirs:
                    r, c = row + dr, col + dc

                    if min(r, c) < 0 or r >= rows or c >= cols or grid[r][c] == "0":
                        continue

                    grid[r][c] = "0"
                    queue.append((r, c))

        ret = 0
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == "1":
                    bfs(r, c)
                    ret += 1
        return ret
