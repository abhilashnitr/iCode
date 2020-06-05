package main.LeetCode.Easy.April27;

import main.LeetCode.Easy.April27.SameTree.TreeNode;

public class MinimumDepthOfBinaryTree {
  public int minDepth(TreeNode n) {
    if(n == null)
      return 0;

    int lH = minDepth(n.left);
    int rH = minDepth(n.right);
    if(n.left==null)
      return rH+1;
    if(n.right==null)
      return lH+1;
    return Math.min(lH, rH)+1;
  }

}
