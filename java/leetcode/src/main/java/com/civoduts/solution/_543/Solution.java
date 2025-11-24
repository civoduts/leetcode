package com.civoduts.solution._543;

public class Solution {
  private static class Ref {
    int max;

    public Ref() {
      this.max = 0;
    }
  }

  private int dfs(
    TreeNode node,
    Ref ref
  ) {
    if (node == null)
      return 0;

    int left = dfs(node.left, ref);
    int right = dfs(node.right, ref);

    ref.max = Math.max(ref.max, left + right);

    return 1 + Math.max(left, right);
  }

  public int diameterOfBinaryTree(TreeNode root) {
    Ref ref = new Ref();
    dfs(root, ref);
    return ref.max;
  }
}
