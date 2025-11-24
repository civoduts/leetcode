package com.civoduts.solution._104;

import java.util.Stack;

public class Solution2 {
  private static class DepthNode {
    TreeNode treeNode;
    Integer depth;

    public DepthNode(TreeNode treeNode, Integer depth) {
      this.treeNode = treeNode;
      this.depth = depth;
    }
  }

  // iterative dfs
  public int maxDepth(TreeNode node) {
    if (node == null)
      return 0;

    int ans = 0;
    Stack<DepthNode> stack = new Stack<>();
    stack.push(new DepthNode(node, 1));

    while (!stack.isEmpty()) {
      DepthNode current = stack.pop();

      if (current.treeNode.left != null)
        stack.push(new DepthNode(current.treeNode.left, current.depth + 1));
      if (current.treeNode.right != null)
        stack.push(new DepthNode(current.treeNode.right, current.depth + 1));

      ans = Math.max(ans, current.depth);
    }

    return ans;
  }
}
