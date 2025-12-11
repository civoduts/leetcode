package com.civoduts.solution._94;


import java.util.ArrayList;
import java.util.List;

public class Solution {
  private void traverse(TreeNode node, List<Integer> path) {
    if (node == null) return;

    traverse(node.left, path);
    path.add(node.val);
    traverse(node.right, path);
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> path = new ArrayList<>();
    traverse(root, path);
    return path;
  }
}
