package com.civoduts.solution._81;

public class Solution {
  public boolean search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] == target) {
        return true;
      }

      // shrink if wrapped from both ends
      if (nums[low] == nums[high]) {
        if (nums[low] == target) {
          return true;
        }

        low++;
        high--;
      }
      // right is sorted
      else if (nums[mid] <= nums[high]) {
        if (nums[mid] < target && target <= nums[high]) {
          low = mid + 1;
        }
        else {
          high = mid - 1;
        }
      }
      // left is sorted
      else if (nums[low] <= nums[mid]) {
        if (nums[low] <= target && target < nums[mid]) {
          high = mid - 1;
        }
        else {
          low = mid + 1;
        }
      }
    }

    return false;
  }
}
