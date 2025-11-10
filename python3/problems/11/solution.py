def calculate_area(left: int, right: int, height: list[int]) -> int:
    return (right - left) * min(height[left], height[right])

class Solution:
    def maxArea(self, height: list[int]) -> int:
        max = 0
        left, right = 0, len(height) - 1

        while left < right:

            area = calculate_area(left, right, height)
            if area > max:
                max = area

            if height[left] >= height[right]:
                right -= 1
            else:  # height[left] < height[right]:
                left += 1

        return max
