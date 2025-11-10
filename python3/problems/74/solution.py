class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        def _search(nums: list[int]) -> bool:
            l, r = 0, len(nums) - 1

            while l <= r:
                mid = l + (r - l) // 2
                if target == nums[mid]:
                    return True
                elif target > nums[mid]:
                    l = mid + 1
                else:  # target < nums[mid]
                    r = mid - 1

            return False

        l, r = 0, len(matrix) - 1

        while l <= r:
            mid = l + (r - l) // 2
            row = matrix[mid]

            if target >= row[0] and target <= row[-1]:
                return _search(row)
            elif target > row[-1]:
                l = mid + 1
            else:  # target < row[0]
                r = mid - 1

        return False
