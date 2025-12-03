package com.civoduts.solution._199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return new ArrayList<>();

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    List<Integer> ans = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.right != null) queue.offer(node.right);
        if (node.left != null) queue.offer(node.left);

        // enqueue right child first, so the next level will be visited right->left.
        // the first node we poll in this level the rightmost one.
        if (i == 0) ans.add(node.val);
      }
    }

    return ans;
  }
}
