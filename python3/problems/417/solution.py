class Solution:
    def pacificAtlantic(self, heights: list[list[int]]) -> list[list[int]]:
        if not heights or not heights[0]:
            return []

        rows, cols = len(heights), len(heights[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(initial_cells: set[tuple[int, int]]) -> set[tuple[int, int]]:
            seen = set(initial_cells)
            stack = list(initial_cells)

            while stack:
                r, c = stack.pop()

                for dr, dc in dirs:
                    rr = r + dr
                    cc = c + dc

                    # out of bounds or already seen
                    if min(rr, cc) < 0 or rr >= rows or cc >= cols or (rr, cc) in seen:
                        continue
                    # traverse the grid until we hit the tallest cell
                    if heights[r][c] > heights[rr][cc]:
                        continue

                    stack.append((rr, cc))
                    seen.add((rr, cc))

            return seen

        pacific = {(0, c) for c in range(cols)}
        pacific |= {(r, 0) for r in range(1, rows)}
        atlantic = {(rows - 1, c) for c in range(cols)}
        atlantic |= {(r, cols - 1) for r in range(rows - 1)}

        valid_cells = dfs(pacific) & dfs(atlantic)
        return [[r, c] for r, c in valid_cells]
