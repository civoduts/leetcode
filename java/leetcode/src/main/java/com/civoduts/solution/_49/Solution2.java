package com.civoduts.solution._49;

import java.util.*;

public class Solution2 {
  static String encode(String s) {
    int[] count = new int[26];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for (int cnt : count) {
      sb.append("#").append(cnt);
    }

    return sb.toString();
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> groups = new HashMap<>(strs.length);
    for (String s : strs) {
      groups.computeIfAbsent(encode(s), _ -> new ArrayList<>()).add(s);
    }

    return new ArrayList<>(groups.values());
  }
}
