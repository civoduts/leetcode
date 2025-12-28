package com.civoduts.solution._200;

public class Solution2 {
  private static final char WATER = '0', LAND = '1';
  private static final int[][] DIRS = {
    {-1, 0}, {1, 0},
    {0, -1}, {0, 1},
  };

  private void dfs(char[][] grid, boolean[][] seen, int r, int c) {
    if (
      Math.min(r, c) < 0 ||
        r >= grid.length ||
        c >= grid[r].length ||
        grid[r][c] != LAND ||
        seen[r][c]
    ) {
      return;
    }

    seen[r][c] = true;

    for (int[] dir : DIRS) {
      int dr = dir[0];
      int dc = dir[1];
      dfs(grid, seen, r + dr, c + dc);
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid[0] == null) {
      return 0;
    }

    int rows = grid.length;
    int cols = grid[0].length;

    boolean[][] seen = new boolean[rows][];
    for (int i = 0; i < rows; i++) {
      seen[i] = new boolean[cols];
    }

    int islands = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == LAND && !seen[r][c]) {
          dfs(grid, seen, r, c);
          islands++;
        }
      }
    }

    return islands;
  }
}
