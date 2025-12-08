package com.civoduts.solution._230;

public class Solution {
  private static final class State {
    int val;
    int counter;

    private State(int val, int counter) {
      this.val = val;
      this.counter = counter;
    }
  }

  private void traverse(TreeNode node, State state) {
    if (node == null || state.counter == 0) return;

    traverse(node.left, state);
    if (state.counter == 0) return;
    if (--state.counter == 0) {
      state.val = node.val;
      return;
    }

    traverse(node.right, state);
  }

  public int kthSmallest(TreeNode root, int k) {
    State state = new State(-1, k);
    traverse(root, state);
    return state.val;
  }
}
