package com.civoduts.solution._130;

public class Solution2 {
  static class Cell {
    final int row;
    final int col;

    public Cell(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private static final char X_CELL = 'X';
  private static final char BORDER_O_CELL = '#';
  private static final char O_CELL = 'O';

  private static final int[][] DIRS = {
    {-1, 0}, {1, 0},
    {0, -1}, {0, 1}
  };

  private void dfs(char[][] board, int row, int col) {
    if (
      row < 0 || row >= board.length ||
        col < 0 || col >= board[row].length ||
        board[row][col] != O_CELL
    ) {
      return;
    }

    board[row][col] = BORDER_O_CELL;
    for (int[] dir : DIRS) {
      int dr = dir[0], dc = dir[1];
      dfs(board, row + dr, col + dc);
    }
  }

  public void solve(char[][] board) {
    int rows = board.length, cols = board[0].length;

    for (int row = 0; row < rows; row++) {
      dfs(board, row, 0);
      dfs(board, row, cols - 1);
    }
    for (int col = 0; col < cols; col++) {
      dfs(board, 0, col);
      dfs(board, rows - 1, col);
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
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
