package TreeUtils;

import LeetCode.SameTree.TreeNode;

public class SumRoottoLeafNumbers {

  int sum=0;
  public void F(TreeNode root,int num)
  {
    if(root==null) return;
    if(root.left==null && root.right==null)
    {
      int v=(((num%1003)*10)%1003+(root.val%1003))%1003;
      sum=(sum+v)%1003;
      return;
    }
    int v=(((num%1003)*10)%1003+(root.val%1003))%1003;
    F(root.left,v);
    F(root.right,v);
  }
  public int sumNumbers(TreeNode root) {
    F(root,0);
    return sum;
  }

}
