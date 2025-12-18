package com.civoduts.solution._3;

import java.util.HashSet;

public class Solution {
  public int lengthOfLongestSubstring(String s) {
    HashSet<Character> seen = new HashSet<>();

    int best = 0;
    for (int l = 0, r = 0; r < s.length(); r++) {
      while (seen.contains(s.charAt(r))) {
        seen.remove(s.charAt(l));
        l++;
      }

      seen.add(s.charAt(r));
      best = Math.max(best, r - l + 1);
    }

    return best;
  }
}
