package com.civoduts.solution._15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      // all numbers > 0, can't sum to 0
      if (nums[i] > 0) break;
      // already considered this number, skip duplicates
      if (i > 0 && nums[i] == nums[i - 1]) continue;

      int j = i + 1, k = nums.length - 1;
      while (j < k) {
        long sum = nums[i] + nums[j] + nums[k];
        if (sum > 0)
          k--;
        else if (sum < 0)
          j++;
        else { // sum == 0
          ans.add(List.of(nums[i], nums[j], nums[k]));

          int left = nums[j], right = nums[k];
          while (j < k && nums[j] == left) j++;
          while (j < k && nums[k] == right) k--;
        }
      }
    }

    return ans;
  }
}