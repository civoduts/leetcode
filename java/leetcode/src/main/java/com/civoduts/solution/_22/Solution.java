package com.civoduts.solution._22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  private void generate(List<String> ret, StringBuilder sb, int opens, int closes, int n) {
    if (opens + closes == 2 * n) {
      ret.add(sb.toString());
      return;
    }
    if (opens < n) {
      sb.append("(");
      generate(ret, sb, opens + 1, closes, n);
      sb.deleteCharAt(sb.length() - 1);
    }
    if (closes < opens) {
      sb.append(")");
      generate(ret, sb, opens, closes + 1, n);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  public List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    generate(ans, sb, 0, 0, n);
    return ans;
  }
}
