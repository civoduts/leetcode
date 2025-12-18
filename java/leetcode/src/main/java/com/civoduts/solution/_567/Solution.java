package com.civoduts.solution._567;

public class Solution {
  private static final int ALPHABET_LEN = 26;

  private boolean matches(int[] freq1, int[] freq2) {
    for (int i = 0; i < ALPHABET_LEN; i++) {
      if (freq1[i] != freq2[i]) {
        return false;
      }
    }
    return true;
  }

  public boolean checkInclusion(String s1, String s2) {
    if (s1 == null || s2 == null) {
      return false;
    }
    if (s1.length() > s2.length()) {
      return false;
    }


    int[] freq1 = new int[ALPHABET_LEN]; // fixed (sliding window is as big as string s1)
    int[] freq2 = new int[ALPHABET_LEN]; // moving (sliding window zoomed into s2 and is as big as string s1)
    for (int end = 0; end < s1.length(); end++) {
      freq1[s1.charAt(end) - 'a']++;
      freq2[s2.charAt(end) - 'a']++;
    }

    if (matches(freq1, freq2)) {
      return true;
    }

    for (int end = s1.length(); end < s2.length(); end++) {
      int start = end - s1.length();
      freq2[s2.charAt(start) - 'a']--;
      freq2[s2.charAt(end) - 'a']++;
      if (matches(freq1, freq2)) {
        return true;
      }
    }

    return false;
  }
}
