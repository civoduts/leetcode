class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(
            r: int,
            c: int,
        ) -> None:
            if min(r, c) < 0 or r >= rows or c >= cols or grid[r][c] == "0":
                return

            grid[r][c] = "0"
            for dr, dc in dirs:
                rr = r + dr
                cc = c + dc
                dfs(rr, cc)

        ret = 0
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == "1":
                    dfs(r, c)
                    ret += 1
        return ret
