package com.civoduts.solution._230;

import java.util.Stack;

public class Solution2 {
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      current = stack.pop();
      if (--k == 0) return current.val;
      current = current.right;
    }

    return -1;
  }
}
