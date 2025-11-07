class Solution:
    def pacificAtlantic(self, heights: list[list[int]]) -> list[list[int]]:
        if not heights or not heights[0]:
            return []

        rows, cols = len(heights), len(heights[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(starts: list[tuple[int, int]]) -> set[tuple[int, int]]:
            seen = set(starts)
            stack = list(starts)

            while stack:
                r, c = stack.pop()
                for dr, dc in dirs:
                    rr = r + dr
                    cc = c + dc

                    if min(rr, cc) < 0 or rr >= rows or cc >= cols or (rr, cc) in seen:
                        continue
                    if heights[rr][cc] < heights[r][c]:
                        continue

                    seen.add((rr, cc))
                    stack.append((rr, cc))
            
            return seen

        pacific_starts = {(0, c) for c in range(cols)}
        pacific_starts |= {(r, 0) for r in range(rows)}
        atlantic_starts = {(rows - 1, c) for c in range(cols)}
        atlantic_starts |= {(r, cols - 1) for r in range(rows)}

        pac = dfs(pacific_starts)
        atl = dfs(atlantic_starts)

        return [[r, c] for r, c in (pac & atl)]
