package com.civoduts.solution._217;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>(nums.length);
    for (int n : nums) {
      if (seen.contains(n)) return true;
      seen.add(n);
    }

    return false;
  }
}
