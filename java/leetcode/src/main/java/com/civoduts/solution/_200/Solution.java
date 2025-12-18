package com.civoduts.solution._200;

public class Solution {
  private static final char WATER = '0', LAND = '1', VISITED_LAND = 'X';
  private static final int[][] DIRS = {
    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
  };

  private void dfs(char[][] grid, int row, int col) {
    if (
      Math.min(row, col) < 0 ||
        row >= grid.length ||
        col >= grid[row].length ||
        grid[row][col] != LAND
    ) {
      return;
    }

    grid[row][col] = VISITED_LAND;

    for (int[] dir : DIRS) {
      int dr = dir[0];
      int dc = dir[1];
      dfs(grid, row + dr, col + dc);
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid[0] == null) {
      return 0;
    }

    int islands = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == LAND) {
          dfs(grid, row, col);
          islands++;
        }
      }
    }

    return islands;
  }
}
