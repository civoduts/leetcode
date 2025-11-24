package com.civoduts.solution._104;

public class Solution {
  private int maxDepth(TreeNode node, int depth) {
    if (node == null)
      return depth;

    int left = maxDepth(node.left, depth);
    int right = maxDepth(node.right, depth);

    return 1 + Math.max(left, right);
  }

  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;

    return maxDepth(root, 1);
  }
}
