package com.civoduts.solution._226;

public class Solution {
  private void invert(TreeNode node) {
    if (node == null)
      return;

    TreeNode tmp = node.left;
    node.left = node.right;
    node.right = tmp;

    invert(node.left);
    invert(node.right);
  }

  public TreeNode invertTree(TreeNode root) {
    invert(root);
    return root;
  }
}
