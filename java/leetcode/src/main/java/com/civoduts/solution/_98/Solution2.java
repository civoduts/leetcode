package com.civoduts.solution._98;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2 {
  private record NodeState(TreeNode node, long min, long max) {
    public boolean isValid() {return min < node.val && node.val < max;}
  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) return true;

    Queue<NodeState> queue = new ArrayDeque<>();
    queue.offer(new NodeState(root, Long.MIN_VALUE, Long.MAX_VALUE));

    while (!queue.isEmpty()) {
      NodeState current = queue.poll();
      if (!current.isValid()) return false;

      if (current.node.left != null)
        queue.offer(new NodeState(current.node.left, current.min, current.node.val));
      if (current.node.right != null)
        queue.offer(new NodeState(current.node.right, current.node.val, current.max));
    }

    return true;
  }
}
