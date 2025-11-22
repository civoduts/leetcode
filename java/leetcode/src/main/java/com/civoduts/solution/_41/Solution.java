package com.civoduts.solution._41;

import java.util.HashSet;

public class Solution {
  public int firstMissingPositive(int[] nums) {
    HashSet<Integer> seen = new HashSet<>();
    for (int n : nums) {
      if (n <= 0) continue;

      seen.add(n);
    }

    int candidate = 0;
    while (seen.contains(candidate))
      candidate++;
    return candidate;
  }
}
