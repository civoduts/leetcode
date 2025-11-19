package com.civoduts.solution._49;

import java.util.*;

public class Solution {
  static String anagram(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> groups = new HashMap<>(strs.length);
    for (String s : strs) {
      groups.computeIfAbsent(anagram(s), _ -> new ArrayList<>()).add(s);
    }

    List<List<String>> ret = new ArrayList<>();
    return new ArrayList<>(groups.values());
  }
}
