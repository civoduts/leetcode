package com.civoduts.solution._695;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

  private static final int WATER = 0, ISLAND = 1, VISITED = 2;
  private static final int[][] DIRS = {
    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
  };

  private int areaOfIsland(
    int r, int c,
    final int[][] grid
  ) {
    final int rows = grid.length, cols = grid[0].length;
    Deque<Cell> queue = new ArrayDeque<>();

    queue.offer(new Cell(r, c));
    grid[r][c] = VISITED;

    int size = 1;
    while (!queue.isEmpty()) {
      Cell curr = queue.poll();

      for (int[] d : DIRS) {
        int nr = curr.row() + d[0];
        int nc = curr.col() + d[1];

        if (
          0 <= nr && nr < rows
            && 0 <= nc && nc < cols
            && grid[nr][nc] == ISLAND
        ) {
          size++;
          queue.offer(new Cell(nr, nc));
          grid[nr][nc] = VISITED;
        }
      }

    }

    return size;
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

  record Cell(int row, int col) {
  }

}
