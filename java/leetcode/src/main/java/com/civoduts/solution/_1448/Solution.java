package com.civoduts.solution._1448;

public class Solution {
  private int dfs(TreeNode node, int max) {
    if (node == null) return 0;


    int good = node.val >= max ? 1 : 0;
    max = Math.max(max, node.val);
    good += dfs(node.left, max);
    good += dfs(node.right, max);

    return good;
  }

  public int goodNodes(TreeNode root) {
    return root != null
      ? dfs(root, root.val)
      : 0;
  }
}
