package main.LeetCode.Easy.April27;

import main.LeetCode.Easy.April27.SameTree.TreeNode;

public class BalancedBinaryTree {

  public boolean isBalanced(TreeNode n) {
    if(n == null)
      return true;

    int lH = findHeight(n.left);
    int rH = findHeight(n.right);
    if(Math.abs(lH-rH) > 1|| !isBalanced(n.left) || !isBalanced(n.right))
      return false;
    else
      return true;
  }

  private int findHeight(TreeNode n)
  {
    if(n == null)
      return 0;

    int lH = findHeight(n.left);
    int rH = findHeight(n.right);

    return Math.max(lH, rH)+1;
  }

  ////////////////////////////////////////////////////////////////////////////////////////

  boolean balanced = true;

  public boolean isBalanced2(TreeNode root) {
    findHeight2(root);
    return balanced;
  }

  private int findHeight2(TreeNode n)
  {
    if(n == null)
      return 0;

    int lH = findHeight2(n.left);
    int rH = findHeight2(n.right);
    if(Math.abs(lH-rH) > 1) {
      balanced = false;
    }
    return Math.max(lH, rH)+1;
  }


}
