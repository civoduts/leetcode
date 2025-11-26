package com.civoduts.solution._226;

import java.util.Stack;

public class Solution2 {
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();

      TreeNode tmp = node.left;
      node.left = node.right;
      node.right = tmp;

      if (node.left != null) stack.push(node.left);
      if (node.right != null) stack.push(node.right);
    }

    return root;
  }
}
