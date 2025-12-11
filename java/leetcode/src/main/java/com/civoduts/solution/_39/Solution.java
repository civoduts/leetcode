package com.civoduts.solution._39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private void dfs(
    List<List<Integer>> ret,
    List<Integer> comb,
    int sum,
    int start,
    int[] candidates,
    int target
  ) {
    if (sum == target) {
      ret.add(new ArrayList<>(comb));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      int nextSum = sum + candidates[i];
      if (nextSum > target) continue; // will we overshoot?

      comb.add(candidates[i]);
      dfs(ret, comb, nextSum, i, candidates, target);
      comb.removeLast();
    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(ans, new ArrayList<>(), 0, 0, candidates, target);
    return ans;
  }
}
