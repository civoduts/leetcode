package com.civoduts.practice._994;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  static class Field {
    final int row;
    final int col;

    public Field(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private static final int EMPTY = 0;
  private static final int FRESH = 1;
  private static final int ROTTEN = 2;

  private static final int[][] dirs = {
    {-1, 0}, {1, 0},
    {0, -1}, {0, 1}
  };

  public int orangesRotting(int[][] grid) {
    Queue<Field> queue = new ArrayDeque<>();
    int fresh = 0;

    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == ROTTEN) {queue.offer(new Field(row, col));}
        else if (grid[row][col] == FRESH) {fresh++;}
      }
    }

    int elapsedMinutes = 0;
    while (fresh > 0 && !queue.isEmpty()) {
      int rottenAtCurrentTime = queue.size();
      for (int i = 0; i < rottenAtCurrentTime; i++) {
        Field current = queue.poll();

        for (int[] dir : dirs) {
          int dr = dir[0], dc = dir[1];
          int nxtRow = current.row + dr;
          int nxtCol = current.col + dc;

          if (
            nxtRow < 0 || nxtRow >= grid.length ||
              nxtCol < 0 || nxtCol >= grid[nxtRow].length ||
              grid[nxtRow][nxtCol] != FRESH
          ) {
            continue;
          }

          grid[nxtRow][nxtCol] = ROTTEN;
          fresh--;

          queue.offer(new Field(nxtRow, nxtCol));
        }

      }
      elapsedMinutes++;
    }

    return fresh == 0 ? elapsedMinutes : -1;
  }
}
