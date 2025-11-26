package com.civoduts.solution._572;

public class Solution2 {
  private void build(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append("X");
      return;
    }
    sb.append("#").append(node.val).append("#");
    build(node.left, sb);
    sb.append("#");
    build(node.right, sb);
  }

  private String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    build(root, sb);
    return sb.toString();
  }

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    if (subRoot == null) return true;
    if (root == null) return false;

    // O(m * n); better with KMP search
    return serialize(root).contains(serialize(subRoot));
  }
}
