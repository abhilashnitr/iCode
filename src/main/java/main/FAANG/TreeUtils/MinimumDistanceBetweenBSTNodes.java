package main.FAANG.TreeUtils;

import main.LeetCode.Easy.April27.SameTree.TreeNode;

public class MinimumDistanceBetweenBSTNodes {
  int min = Integer.MAX_VALUE;

  public int minDiffInBST(TreeNode root) {
    dfs(root, null);
    return min;
  }
  Integer dfs(TreeNode root, Integer prev) {
    if (root == null) {
      return prev;
    }

    prev = dfs(root.left, prev);
    if (prev != null) {
      min = Math.min(root.val - prev, min);
    }

    prev = dfs(root.right, root.val);
    return prev;
  }

  Integer res = Integer.MAX_VALUE, pre = null;
  public int minDiffInBST2(TreeNode root) {
    if (root.left != null) minDiffInBST2(root.left);
    if (pre != null) res = Math.min(res, root.val - pre);
    pre = root.val;
    if (root.right != null) minDiffInBST2(root.right);
    return res;
  }

}
