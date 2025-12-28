package com.civoduts.practice._130;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  static class Cell {
    final int row;
    final int col;

    public Cell(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private static final char X_CELL = 'X';
  private static final char O_CELL = 'O';
  private static final char BORDER_O_CELL = '#';

  private static final int[][] dirs = {
    {-1, 0}, {1, 0},
    {0, -1}, {0, 1}
  };

  private void mark(char[][] board, Queue<Cell> queue, int row, int col) {
    if (
      row < 0 || row >= board.length ||
        col < 0 || col >= board[0].length ||
        board[row][col] != O_CELL
    ) {
      return;
    }

    board[row][col] = BORDER_O_CELL;
    queue.offer(new Cell(row, col));
  }

  public void solve(char[][] board) {
    Queue<Cell> queue = new ArrayDeque<>();

    // idea: identify all O cells on the border of the board, and bfs from them to find adjacent O cells.
    // these regions cannot be captured ever.
    for (int row = 0; row < board.length; row++) {
      mark(board, queue, row, 0);
      mark(board, queue, row, board[0].length - 1);
    }
    for (int col = 0; col < board[0].length; col++) {
      mark(board, queue, 0, col);
      mark(board, queue, board.length - 1, col);
    }


    // try to mark border O adjacent O cells
    while (!queue.isEmpty()) {
      Cell current = queue.poll();

      for (int[] dir : dirs) {
        int dr = dir[0], dc = dir[1];

        int nxtRow = current.row + dr;
        int nxtCol = current.col + dc;

        mark(board, queue, nxtRow, nxtCol);
      }
    }

    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        if (board[row][col] == O_CELL) {
          board[row][col] = X_CELL;
        }
        else if (board[row][col] == BORDER_O_CELL) {
          board[row][col] = O_CELL;
        }
      }
    }
  }
}
