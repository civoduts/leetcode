package com.civoduts.solution._104;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3 {
  // iterative bfs
  public int maxDepth(TreeNode node) {
    if (node == null)
      return 0;

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.offer(node);

    int levels = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        TreeNode current = queue.poll();

        if (current.left != null) queue.offer(current.left);
        if (current.right != null) queue.offer(current.right);
      }
      levels++;
    }

    return levels;
  }
}
