package com.civoduts.solution._271;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private static final char SEP = '#';

  private static Integer tryConvertInt(String s) {
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException ex) {
      return null;
    }
  }

  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      sb.append(s.length()).append(SEP).append(s);
    }
    return sb.toString();
  }

  public List<String> decode(String str) {
    List<String> ans = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
      int j = i;

      while (i < str.length() && str.charAt(i) != SEP) i++;
      if (i == str.length()) break;
      // corrupted encoding

      Integer len = tryConvertInt(str.substring(j, i));
      i++; // skip '#'
      if (len == null || len < 0 || len + i > str.length()) break;

      int end = i + len;
      ans.add(str.substring(i, end));
      i = end;
    }
    return ans;
  }
}
