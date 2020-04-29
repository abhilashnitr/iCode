package LeetCode;

import LeetCode.SameTree.TreeNode;

public class MaximumDepthofBinaryTree {
  public int maxDepth(TreeNode root) {
    if(root==null)
      return 0;
    int l=maxDepth(root.left);
    int r=maxDepth(root.right);
    return l>r?l+1:r+1;
  }

}
