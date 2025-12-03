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
      int last = -1;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        last = node.val;

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      ans.add(last);
    }

    return ans;
  }
}
