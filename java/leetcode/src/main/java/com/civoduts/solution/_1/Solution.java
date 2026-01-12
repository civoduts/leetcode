package com.civoduts.solution._1;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> pos = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int other = target - nums[i];
      if (pos.containsKey(other)) {
        return new int[]{pos.get(other), i};
      }
      pos.put(nums[i], i);
    }

    return new int[]{};
  }
}
