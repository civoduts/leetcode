def twoSum(nums: list[int], start: int, target: int) -> list[list[int]]:
    i, j = start, len(nums) - 1
    ret = []

    while i < j:
        candidate = nums[i] + nums[j]

        if candidate == target:
            ret.append([-target, nums[i], nums[j]])
            # we need to skip numbers such that new elements are not equivalent to the old numbers
            # found on i and j because for fixed `target` and fixed `i`, the only viable solution
            # for `j` is the one we already have; similiarly, for fixed `target` and fixed `j`
            # the only solution would be the on we had on old `i`. Therefore, the logical
            # conclusion is to skip all the repeating duplicates.
            left, right = nums[i], nums[j]
            while i < j and nums[i] == left:
                i += 1
            while i < j and nums[j] == right:
                j -= 1

        elif candidate > target:
            j -= 1
        else:  # candidate < target
            i += 1

    return ret


class Solution:
    def threeSum(self, nums: list[int]) -> list[list[int]]:
        sorted_nums = sorted(nums)
        triplets = []

        for i in range(len(sorted_nums) - 2):
            num = sorted_nums[i]

            # we already found this solution, skip duplicate targets
            if i > 0 and num == sorted_nums[i - 1]:
                continue

            # the list is sorted and non-decreasing
            # therefore num + a + b can never be 0
            if num > 0:
                break

            # a + b = -num
            res = twoSum(sorted_nums, i + 1, -num)
            triplets.extend(res)

        return triplets
