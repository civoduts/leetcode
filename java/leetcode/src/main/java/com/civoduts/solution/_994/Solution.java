package com.civoduts.solution._994;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  private static final int EMPTY = 0, FRESH_ORANGE = 1, ROTTEN_ORANGE = 2;
  private static final int[][] DIRS = {
    {-1, 0}, {1, 0}, {0, -1}, {0, 1}
  };

  private boolean infect(int r, int c, int[][] grid, Deque<Cell> queue) {
    final int rows = grid.length, cols = grid[0].length;
    if (0 <= r && r < rows && 0 <= c && c < cols && grid[r][c] == FRESH_ORANGE) {
      grid[r][c] = ROTTEN_ORANGE;
      queue.add(new Cell(r, c));
      return true;
    }
    return false;
  }

  public int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
      return -1;

    final int rows = grid.length, cols = grid[0].length;
    Deque<Cell> queue = new ArrayDeque<>();

    int fresh = 0;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == ROTTEN_ORANGE) queue.offer(new Cell(r, c));
        else if (grid[r][c] == FRESH_ORANGE) fresh++;
      }
    }

    if (fresh == 0) return 0;

    int minutes = 0;
    while (fresh > 0 && !queue.isEmpty()) {
      int level = queue.size();
      while (level-- > 0) {
        Cell curr = queue.poll();
        for (int[] d : DIRS) {
          int nr = curr.row + d[0], nc = curr.col + d[1];
          if (infect(nr, nc, grid, queue)) fresh--;
        }
      }
      minutes += 1;
    }

    return fresh == 0 ? minutes : -1;
  }

  private static final class Cell {
    final int row, col;

    public Cell(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}

