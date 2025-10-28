
class Solution:

    def _row_ok(self, board: list[list[str]], row: int) -> bool:
        seen = set()
        for elem in board[row]:
            if elem == ".":
                continue
            if elem in seen:
                return False
            seen.add(elem)
        return True

    def _column_ok(self, board: list[list[str]], col: int) -> bool:
        seen = set()
        for i in range(9):
            elem = board[i][col]
            if elem == ".":
                continue
            if elem in seen:
                return False
            seen.add(elem)
        return True

    def _box_ok(self, board: list[list[str]], box: int) -> bool:
        row = (box // 3) * 3
        col = (box % 3) * 3

        seen = set()
        for r in range(row, row + 3):
            for c in range(col, col + 3):
                elem = board[r][c]
                if elem == ".":
                    continue
                if elem in seen:
                    return False
                seen.add(elem)

        return True

    def isValidSudoku(self, board: list[list[str]]) -> bool:
        for i in range(9):
            if not (
                self._row_ok(board, i)
                and self._column_ok(board, i)
                and self._box_ok(board, i)
            ):
                return False
        return True
