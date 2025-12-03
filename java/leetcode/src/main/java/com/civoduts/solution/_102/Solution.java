package com.civoduts.solution._102;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) return new ArrayList<>();

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    List<List<Integer>> ans = new ArrayList<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> level = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        level.add(node.val);

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      ans.add(level);
    }

    return ans;
  }
}
