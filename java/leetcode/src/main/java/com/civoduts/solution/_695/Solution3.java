package com.civoduts.solution._695;

public class Solution3 {

  private static final int WATER = 0, ISLAND = 1, VISITED = 2;
  private static final int[][] DIRS = {
    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
  };

  private int areaOfIsland(
    int r, int c,
    final int[][] grid
  ) {
    if (
      r < 0 || r >= grid.length
        || c < 0 || c >= grid[0].length
        || grid[r][c] != ISLAND
    )
      return 0;

    grid[r][c] = VISITED;

    int area = 1;
    area += areaOfIsland(r - 1, c, grid);
    area += areaOfIsland(r + 1, c, grid);
    area += areaOfIsland(r, c - 1, grid);
    area += areaOfIsland(r, c + 1, grid);

    return area;
  }

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

    final int rows = grid.length, cols = grid[0].length;

    int maxArea = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == ISLAND)
          maxArea = Math.max(maxArea, areaOfIsland(r, c, grid));
      }
    }

    return maxArea;
  }
}
