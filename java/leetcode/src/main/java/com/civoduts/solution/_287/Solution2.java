package com.civoduts.solution._287;

public class Solution2 {
  // breaks constraint: no mutation of input array
  // assumption:  all nums[i] > 0
  // how: flip i-th number from positive to negative, and if flipping back from negative to positive then
  // that is the duplicate. for 0-indexed array, the index is calculated as index=abs(nums[i]) - 1. Absolute value
  // is necessary because nums[i] could have been previously flipped.
  public int findDuplicate(int[] nums) {
    for (int n : nums) {
      if (nums[Math.abs(n) - 1] < 0)
        return Math.abs(n);
      nums[Math.abs(n) - 1] *= -1;
    }
    return -1;
  }
}
