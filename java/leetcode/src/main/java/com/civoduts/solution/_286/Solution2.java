package com.civoduts.solution._286;

public class Solution2 {
  private static final int WATER = -1;
  private static final int TREASURE = 0;
  private static final int PATH = 2147483647;

  private static final int[][] dirs = {
    {-1, 0}, {1, 0},
    {0, -1}, {0, 1}
  };

  private void dfs(int[][] grid, int row, int col, int distance) {
    grid[row][col] = distance;

    for (int i = 0; i < dirs.length; i++) {
      int dr = dirs[i][0], dc = dirs[i][1];

      int nxtRow = row + dr;
      int nxtCol = col + dc;

      if (
        nxtRow < 0 || nxtRow >= grid.length ||
          nxtCol < 0 || nxtCol >= grid[nxtRow].length ||
          grid[nxtRow][nxtCol] == TREASURE ||
          grid[nxtRow][nxtCol] == WATER ||
          grid[nxtRow][nxtCol] <= distance + 1
      ) {
        continue;
      }

      dfs(grid, nxtRow, nxtCol, distance + 1);
    }
  }

  public void islandsAndTreasure(int[][] grid) {
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[r].length; c++) {
        if (grid[r][c] == TREASURE) {
          dfs(grid, r, c, 0);
        }
      }
    }
  }
}
