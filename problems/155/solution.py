class MinStack:

    def __init__(self):
        self._stack = []

    # add both current value and min value to the stack together
    def push(self, val: int) -> None:
        min_ = val if not self._stack else min(val, self._stack[-1][1])
        self._stack.append((val, min_))

    def pop(self) -> None:
        self._stack.pop()

    def top(self) -> int:
        val, _ = self._stack[-1]
        return val

    def getMin(self) -> int:
        _, min_ = self._stack[-1]
        return min_
