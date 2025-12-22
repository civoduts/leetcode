package com.civoduts.solution._130;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
  private static final char X_CELL = 'X';
  private static final char BORDER_O_CELL = '#';
  private static final char O_CELL = 'O';

  private static final int[][] DIRS = {
    {-1, 0}, {1, 0},
    {0, -1}, {0, 1}
  };

  private void mark(int row, int col, char[][] board, Deque<Cell> queue) {
    int rows = board.length, cols = board[0].length;
    if (0 <= row && row < rows && 0 <= col && col < cols && board[row][col] == O_CELL) {
      board[row][col] = BORDER_O_CELL;
      queue.add(new Cell(row, col));
    }
  }

  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) return;

    final int rows = board.length, cols = board[0].length;
    Deque<Cell> queue = new ArrayDeque<>();

    for (int row = 0; row < rows; row++) {
      mark(row, 0, board, queue);
      mark(row, cols - 1, board, queue);
    }

    for (int col = 0; col < cols; col++) {
      mark(0, col, board, queue);
      mark(rows - 1, col, board, queue);
    }

    while (!queue.isEmpty()) {
      Cell curr = queue.poll();
      for (int[] d : DIRS) {
        int nr = curr.row() + d[0];
        int nc = curr.col() + d[1];

        mark(nr, nc, board, queue);
      }
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (board[row][col] == O_CELL)
          board[row][col] = X_CELL;
        else if (board[row][col] == BORDER_O_CELL) {
          board[row][col] = O_CELL;
        }
      }
    }
  }
}

record Cell(int row, int col) {
}
