package com.civoduts.solution._78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private void dfs(
    List<List<Integer>> ret,
    List<Integer> subset,
    int start,
    int[] nums
  ) {
    ret.add(new ArrayList<>(subset));

    for (int j = start; j < nums.length; j++) {
      subset.add(nums[j]);
      dfs(ret, subset, j + 1, nums);
      subset.remove(subset.size() -1 );
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), 0, nums);
    return ans;
  }
}
