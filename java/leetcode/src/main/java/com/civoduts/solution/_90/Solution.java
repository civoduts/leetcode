package com.civoduts.solution._90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  private void subset(
    List<Integer> path,
    List<List<Integer>> ret,
    int[] nums,
    int start
  ) {
    ret.add(new ArrayList<>(path));
    for (int i = start; i < nums.length; i++) {
      // skip dupes at this recursion depth
      if (i > start && nums[i] == nums[i - 1]) continue;
      path.add(nums[i]);
      subset(path, ret, nums, i + 1);
      path.removeLast();
    }

  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    subset(new ArrayList<>(), ans, nums, 0);
    return ans;
  }
}
