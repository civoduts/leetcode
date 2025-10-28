class Solution:
    def twoSum(self, numbers: list[int], target: int) -> list[int]:
        for i, num in enumerate(numbers):
            found = bin_search(numbers, i + 1, len(numbers) - 1, target - num)
            if found != -1:
                return [i + 1, found + 1]


def bin_search(
    numbers: list[int],
    start: int,
    end: int,
    target: int,
) -> list[int]:
    while start <= end:
        mid = (end + start) // 2

        if numbers[mid] == target:
            return mid
        elif numbers[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return -1

Solution().twoSum([2,3,4], 6)