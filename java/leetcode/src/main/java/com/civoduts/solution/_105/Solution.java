package com.civoduts.solution._105;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  private TreeNode build(
    Map<Integer, Integer> inorderMap,
    int[] preorder,
    int pStart,
    int pEnd,
    int iStart,
    int iEnd
  ) {
    if (iStart > iEnd)
      return null;
    if (pStart > pEnd)
      return null;

    int rootVal = preorder[pStart];

    int iRootIndx = inorderMap.get(rootVal);
    int iLeftStart = iStart;
    int iLeftEnd = iRootIndx - 1;
    int iRightStart = iRootIndx + 1;
    int iRightEnd = iEnd;

    int pLeftStart = pStart + 1;
    int pLeftEnd = pLeftStart + (iLeftEnd - iLeftStart);
    int pRightStart = pLeftEnd + 1;
    int pRightEnd = pEnd;

    TreeNode node = new TreeNode(rootVal);
    node.left = build(inorderMap, preorder, pLeftStart, pLeftEnd, iLeftStart, iLeftEnd);
    node.right = build(inorderMap, preorder, pRightStart, pRightEnd, iRightStart, iRightEnd);

    return node;
  }

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);

    return build(
      inorderMap,
      preorder,
      0, preorder.length - 1,
      0, preorder.length - 1
    );
  }
}
