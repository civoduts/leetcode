package com.civoduts.solution._100;

import java.util.Stack;

public class Solution2 {
  record Pair(TreeNode p, TreeNode q) {
    static Pair of(TreeNode p, TreeNode q) {return new Pair(p, q);}
  }

  private boolean isSameNode(TreeNode p, TreeNode q) {
    if (p == null || q == null)
      return p == q;
    return p.val == q.val;
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    Stack<Pair> stack = new Stack<>();
    stack.push(Pair.of(p, q));

    while (!stack.isEmpty()) {
      Pair current = stack.pop();
      TreeNode pp = current.p();
      TreeNode qq = current.q();

      if (!isSameNode(pp, qq))
        return false;

      if (pp != null && qq != null) {
        stack.push(Pair.of(pp.left, qq.left));
        stack.push(Pair.of(pp.right, qq.right));
      }
    }

    return true;
  }
}
