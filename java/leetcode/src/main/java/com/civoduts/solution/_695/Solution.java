package com.civoduts.solution._695;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {

  private static final int WATER = 0, ISLAND = 1;
  private static final int[][] DIRS = {
    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
  };

  private int areaOfIsland(
    int r, int c,
    final int[][] grid,
    final Set<Cell> seen
  ) {
    final int rows = grid.length, cols = grid[0].length;
    Deque<Cell> queue = new ArrayDeque<>();

    queue.offer(new Cell(r, c));
    seen.add(new Cell(r, c));

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
            && !seen.contains(new Cell(nr, nc))
        ) {
          size++;
          queue.offer(new Cell(nr, nc));
          seen.add(new Cell(nr, nc));
        }
      }

    }

    return size;
  }

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

    final int rows = grid.length, cols = grid[0].length;
    Set<Cell> seen = new HashSet<>();

    int maxArea = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == ISLAND && !seen.contains(new Cell(r, c)))
          maxArea = Math.max(maxArea, areaOfIsland(r, c, grid, seen));
      }
    }

    return maxArea;
  }

  record Cell(int row, int col) {
  }

}
