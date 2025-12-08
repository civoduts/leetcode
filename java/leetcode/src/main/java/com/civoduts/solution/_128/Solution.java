package com.civoduts.solution._128;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public int longestConsecutive(int[] nums) {
    int longest = 0;
    Set<Integer> uniq = new HashSet<>();
    for (int n : nums) {
      uniq.add(n);
    }

    for (int n : uniq) {
      if (uniq.contains(n - 1))
        continue;

      int count = 1;
      while (uniq.contains(n + count)) {
        count++;
      }

      if (count > longest)
        longest = count;
    }

    return longest;
  }
}
