package com.civoduts.solution._153;

public class Solution {
  public int findMin(int[] nums) {
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;

      if (nums[mid] > nums[high]) {
        low = mid + 1;
      }
      else { // nums[mid] < nums[high]
        high = mid;
      }
    }

    return nums[low];
  }
}
