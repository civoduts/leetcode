package com.civoduts.solution._216;

import java.util.*;

public class Solution {
  private void backtrack(
    int start,
    List<Integer> comb,
    List<List<Integer>> ret,
    int target,
    int k
  ) {
    if (comb.size() == k) {
      if (target == 0) ret.add(new ArrayList<>(comb));
      return;
    }

    for (int i = start; i <= 9; i++) {
      if (target - i < 0) break; // too much. no point trying bigger numbers
      comb.add(i);
      backtrack(i + 1, comb, ret, target - i, k);
      comb.removeLast();
    }
  }

  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(1, new ArrayList<>(), ans, n, k);
    return ans;
  }
}
