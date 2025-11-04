from collections import deque


class Solution:
    def islandsAndTreasure(self, grid: list[list[int]]) -> None:
        if not grid or not grid[0]:
            return

        WATER, TREASURE, UNVISITED_LAND = -1, 0, 2147483647
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        rows, cols = len(grid), len(grid[0])

        queue = deque()
        visited = set()

        # locate treasures first; process traversable cells around in one sweep
        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == TREASURE:
                    queue.append((r, c))
                    visited.add((r, c))

        distance = 1
        while queue:
            # sweep all same-leveled cells
            for _ in range(len(queue)):
                r, c = queue.popleft()
                for dr, dc in dirs:
                    rr = r + dr
                    cc = c + dc

                    if (
                        0 <= rr < rows
                        and 0 <= cc < cols
                        and (rr, cc) not in visited
                        and grid[rr][cc] != WATER
                    ):
                        if grid[rr][cc] == UNVISITED_LAND:
                            grid[rr][cc] = distance
                        queue.append((rr, cc))
                        visited.add((rr, cc))

            distance += 1
