OPERATIONS = {
    "+": lambda x, y: x + y,
    "-": lambda x, y: x - y,
    "*": lambda x, y: x * y,
    "/": lambda x, y: int(x / y),
}


def is_operator(token: str) -> bool:
    return token in OPERATIONS


class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        numbers = []

        for t in tokens:
            if is_operator(t):
                right = numbers.pop()
                left = numbers.pop()

                operator = OPERATIONS[t]
                numbers.append(operator(left, right))
            else:
                numbers.append(int(t))

        return numbers[-1]
