class Solution:
    # two pass, O(n)
    def search(self, nums: list[int], target: int) -> int:
        n = len(nums)

        if n == 0:
            return -1

        def find_pivot() -> int:
            l, r = 0, len(nums) - 1
            while l < r:
                mid = l + (r - l) // 2

                if nums[mid] > nums[r]:
                    l = mid + 1
                else:
                    r = mid
            return l

        def bsearch(left: int, right: int) -> int:
            while left <= right:
                mid = left + (right - left) // 2
                if nums[mid] == target:
                    return mid
                elif target < nums[mid]:
                    right = mid - 1
                else:  # nums[mid] > target
                    left = mid + 1
            return -1

        pivot = find_pivot()

        if pivot == 0:
            return bsearch(0, n - 1)

        if nums[pivot] <= target <= nums[-1]:
            return bsearch(pivot, n - 1)
        else:
            return bsearch(0, pivot - 1)
