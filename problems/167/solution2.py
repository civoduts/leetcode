class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        i, j = 0, len(numbers) - 1

        while i < j:
            total = numbers[i] + numbers[j]

            if total == target:
                return [i + 1, j + 1]
            elif total > target:
                j -= 1
            else:  # total < target
                i += 1

        return [-1, -1]
