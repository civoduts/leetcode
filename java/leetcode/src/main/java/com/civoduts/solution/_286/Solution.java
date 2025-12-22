package com.civoduts.solution._286;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  private static final int TREASURE = 0;
  private static final int PATH = 2147483647;

  static class Cell {
    final int row;
    final int col;

    public Cell(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  public void islandsAndTreasure(int[][] grid) {
    Queue<Cell> queue = new ArrayDeque<>();
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == TREASURE) {
          queue.offer(new Cell(row, col));
        }
      }
    }

    final int[][] dirs = new int[][]{
      {-1, 0}, {1, 0},
      {0, -1}, {0, 1}
    };


    while (!queue.isEmpty()) {
      Cell current = queue.poll();

      for (int[] dir : dirs) {
        int nxtRow = current.row + dir[0];
        int nxtCol = current.col + dir[1];

        if (
          nxtRow < 0 || nxtRow >= grid.length ||
            nxtCol < 0 || nxtCol >= grid[nxtRow].length ||
            grid[nxtRow][nxtCol] != PATH
        ) {
          continue;
        }

        queue.offer(new Cell(nxtRow, nxtCol));
        grid[nxtRow][nxtCol] = grid[current.row][current.col] + 1;
      }
    }

  }
}
