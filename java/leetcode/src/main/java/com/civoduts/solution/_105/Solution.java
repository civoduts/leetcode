package com.civoduts.solution._105;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private TreeNode build(
    Map<Integer, Integer> inorderMap,
    int[] preorder,
    int pStart,
    int iStart,
    int iEnd
  ) {
    if (iStart > iEnd) return null;

    int rootVal = preorder[pStart];
    int rootIndex = inorderMap.get(rootVal);
    int leftSize = rootIndex - iStart;

    TreeNode node = new TreeNode(rootVal);
    node.left = build(
      inorderMap, preorder,
      pStart + 1,
      iStart, rootIndex - 1
    );
    node.right = build(
      inorderMap, preorder,
      pStart + leftSize + 1,
      rootIndex + 1, iEnd
    );

    return node;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);

    return build(
      inorderMap,
      preorder,
      0,
      0, inorder.length - 1
    );
  }
}
