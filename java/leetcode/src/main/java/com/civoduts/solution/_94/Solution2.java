package com.civoduts.solution._94;


import java.util.*;

public class Solution2 {
  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;

    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      current = stack.pop();
      path.add(current.val);
      current = current.right;
    }

    return path;
  }
}
