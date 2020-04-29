package LeetCode;

import LeetCode.SameTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

  public boolean isSymmetric(TreeNode root) {

    if(root==null)
      return true;

    return isMirror(root.left,root.right);
  }

  boolean isMirror(TreeNode node1, TreeNode node2)
  {
    if (node1 == null && node2 == null)
      return true;

    if (node1 != null && node2 != null && node1.val == node2.val)
      return (isMirror(node1.left, node2.right)
          && isMirror(node1.right, node2.left));


    return false;
  }

  public boolean isSymmetric1(TreeNode root) {
    if(root==null)
      return true;
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root.left);
    q.add(root.right);
    while(!q.isEmpty()){
      TreeNode tempLeft = q.remove();
      TreeNode tempRight = q.remove();
      if (tempLeft==null && tempRight==null)
        continue;
      if ((tempLeft==null && tempRight!=null) ||
          (tempLeft!=null && tempRight==null))
        return false;
      if (tempLeft.val != tempRight.val)
        return false;
      q.add(tempLeft.left);
      q.add(tempRight.right);
      q.add(tempLeft.right);
      q.add(tempRight.left);
    }
    return true;
  }


}
