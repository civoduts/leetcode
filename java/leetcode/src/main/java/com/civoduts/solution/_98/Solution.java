package com.civoduts.solution._98;

public class Solution {
  private boolean valid(TreeNode node, long min, long max) {
    if (node == null) return true;
    if (!(min < node.val && node.val < max)) return false;

    return
      valid(node.left, min, node.val) &&
        valid(node.right, node.val, max);
  }

  public boolean isValidBST(TreeNode root) {
    return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }
}
