package com.civoduts.solution._40;

import java.util.*;

public class Solution {
  private void dfs(
    List<List<Integer>> ret,
    List<Integer> comb,
    int start,
    int[] candidates,
    int target
  ) {
    if (target == 0) {
      ret.add(new ArrayList<>(comb));
      return;
    }

    for (int i = start; i < candidates.length; i++) {
      // at this recursion depth, you may not start with the same number twice
      // e.g. {1, 1, 2}
      // depth 0: you can choose 1 once, 2 once (can't do 1,1)
      // depth 1: if you picked 1, you can choose the second 1 once, or 2 once
      // depth 1: if you picked 2, you are done
      // depth 2: if you picked 1, 1 you can choose 2
      // depth 2: if you picked 1, 2 you are done
      if (i > start && candidates[i] == candidates[i - 1]) continue;
      if (0 > target - candidates[i]) return; // will we overshoot?

      comb.add(candidates[i]);
      dfs(ret, comb, i + 1, candidates, target - candidates[i]);
      comb.removeLast();
    }
  }

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(ans, new ArrayList<>(), 0, candidates, target);
    return ans;
  }
}
