package com.civoduts.solution._46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private void backtrack(
    int[] nums,
    boolean[] seen, // high iq move (no HashSet needed)
    List<Integer> perm,
    List<List<Integer>> ret
  ) {
    if (perm.size() == nums.length) {
      ret.add(new ArrayList<>(perm));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (seen[i])
        continue;

      perm.add(nums[i]);
      seen[i] = true;
      backtrack(nums, seen, perm, ret);
      perm.removeLast();
      seen[i] = false;
    }
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(nums, new boolean[nums.length], new ArrayList<>(), ans);
    return ans;
  }
}
