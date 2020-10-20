package main.TreeUtils;

import main.LeetCode.Easy.April27.SameTree.TreeNode;

public class KthSmallestInBST {

  static int count = 0;
  static int val = 0;
  public static void inorder(TreeNode A, int B){
    if(A == null || val != 0){
      return;
    }
    inorder(A.left, B);
    count++;
    if(count == B){
      val = A.val;
      return;
    }
    inorder(A.right, B);
  }
  public int kthsmallest(TreeNode A, int B) {
    count = 0;
    val = 0;
    inorder(A, B);
    return(val);
  }


}
