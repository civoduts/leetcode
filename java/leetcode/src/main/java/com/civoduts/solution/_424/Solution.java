package com.civoduts.solution._424;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public int characterReplacement(String s, int k) {
    char[] chArray = s.toCharArray();
    Map<Character, Integer> freq = new HashMap<>();

    int best = 0;
    int maxFreq = 0;

    for (int l = 0, r = 0; r < s.length(); r++) {
      int currentFreq = 1 + freq.getOrDefault(chArray[r], 0);
      freq.put(chArray[r], currentFreq);
      maxFreq = Math.max(maxFreq, currentFreq);

      while ((r - l + 1 - maxFreq) > k) {
        freq.put(chArray[l], freq.get(chArray[l]) - 1);
        l++;
      }

      best = Math.max(best, r - l + 1);
    }

    return best;
  }
}
