package _235;

public class Solution2 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    while (root != null) {
      if (p.val < root.val && q.val < root.val)
        root = root.left;
      else if (root.val < p.val && root.val < q.val)
        root = root.right;
      else
        return root;
    }

    return null;
  }
}
