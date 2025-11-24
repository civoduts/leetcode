package com.civoduts.solution._1448;

import java.util.ArrayDeque;
import java.util.Deque;


public class Solution2 {
  static class TrackingTreeNode {
    final TreeNode treeNode;
    final int maxOnPath;

    public TrackingTreeNode(TreeNode root) {
      this.treeNode = root;
      this.maxOnPath = root.val;
    }

    public TrackingTreeNode(TreeNode treeNode, int maxOnPath) {
      this.treeNode = treeNode;
      this.maxOnPath = maxOnPath;
    }

    public boolean isGoodNode() {
      return treeNode.val >= maxOnPath;
    }

    public TrackingTreeNode createLeft() {
      if (treeNode.left == null)
        return null;

      return new TrackingTreeNode(
        treeNode.left,
        Math.max(maxOnPath, treeNode.left.val)
      );
    }

    public TrackingTreeNode createRight() {
      if (treeNode.right == null)
        return null;

      return new TrackingTreeNode(
        treeNode.right,
        Math.max(maxOnPath, treeNode.right.val)
      );
    }
  }

  public int goodNodes(TreeNode root) {
    if (root == null)
      return 0;

    int good = 0;
    Deque<TrackingTreeNode> queue = new ArrayDeque<>();
    queue.add(new TrackingTreeNode(root));

    while (!queue.isEmpty()) {
      TrackingTreeNode parent = queue.poll();

      if (parent.isGoodNode())
        good++;

      TrackingTreeNode left = parent.createLeft(), right = parent.createRight();
      if (left != null)
        queue.offer(left);
      if (right != null)
        queue.offer(right);
    }

    return good;
  }
}
