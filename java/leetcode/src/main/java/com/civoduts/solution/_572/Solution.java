package com.civoduts.solution._572;

public class Solution {
  private boolean isIdentical(TreeNode p, TreeNode q) {
    if (p == null || q == null)
      return p == q;
    if (p.val != q.val)
      return false;

    return isIdentical(p.left, q.left) && isIdentical(p.right, q.right);
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (subRoot == null) return true;
    if (root == null) return false;
    if (isIdentical(root, subRoot)) return true;
    return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }
}
