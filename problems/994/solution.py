from collections import deque


class Solution:
    def orangesRotting(self, grid: list[list[int]]) -> int:
        EMPTY, FRESH_ORANGE, ROTTEN_ORANGE = 0, 1, 2

        if not grid:
            return -1

        rows, cols = len(grid), len(grid[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        queue = deque()
        fresh = 0
        time = 0

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == FRESH_ORANGE:
                    fresh += 1
                elif grid[r][c] == ROTTEN_ORANGE:
                    queue.append((r, c))

        while fresh > 0 and queue:
            for _ in range(len(queue)):
                row, col = queue.popleft()

                for dr, dc in dirs:
                    rr, cc = row + dr, col + dc

                    if (
                        min(rr, cc) < 0
                        or rr >= rows
                        or cc >= cols
                        or grid[rr][cc] != FRESH_ORANGE
                    ):
                        continue

                    grid[rr][cc] = ROTTEN_ORANGE
                    fresh -= 1
                    queue.append((rr, cc))

            time += 1

        return time if fresh == 0 else -1
