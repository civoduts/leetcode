package com.civoduts.solution._1448;

import java.util.ArrayDeque;
import java.util.Deque;


public class Solution2 {
  static class TrackingTreeNode {
    private final TreeNode treeNode;
    private final int maxSoFar;

    public TrackingTreeNode(TreeNode treeNode, int maxSoFar) {
      this.treeNode = treeNode;
      this.maxSoFar = maxSoFar;
    }

    public boolean isGoodNode() {
      return treeNode.val >= maxSoFar;
    }

    public TrackingTreeNode createLeft() {
      if (treeNode.left == null)
        return null;

      return new TrackingTreeNode(
        treeNode.left,
        Math.max(maxSoFar, treeNode.val)
      );
    }

    public TrackingTreeNode createRight() {
      if (treeNode.right == null)
        return null;

      return new TrackingTreeNode(
        treeNode.right,
        Math.max(maxSoFar, treeNode.val)
      );
    }
  }

  public int goodNodes(TreeNode root) {
    if (root == null)
      return 0;

    int good = 1;
    Deque<TrackingTreeNode> queue = new ArrayDeque<>();
    queue.add(new TrackingTreeNode(root, Integer.MIN_VALUE));

    while (!queue.isEmpty()) {
      TrackingTreeNode parent = queue.poll();

      TrackingTreeNode left = parent.createLeft();
      if (left != null) {
        good += left.isGoodNode() ? 1 : 0;
        queue.offer(left);
      }

      TrackingTreeNode right = parent.createRight();
      if (right != null) {
        good += right.isGoodNode() ? 1 : 0;
        queue.offer(right);
      }
    }

    return good;
  }
}
