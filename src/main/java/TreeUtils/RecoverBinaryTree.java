package TreeUtils;

import LeetCode.SameTree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;

public class RecoverBinaryTree {
  private Integer first, second;
  private TreeNode prev;

  private void visit(TreeNode current) {
    if (prev != null && prev.val > current.val) {
      first = current.val;
      if (second == null)
        second = prev.val;
    }
    prev = current;
  }

  private void morrisTraversal(TreeNode root) {
    TreeNode current = root;
    while (current != null) {
      if (current.left == null) {
        visit(current);
        current = current.right;
      } else {
        TreeNode prev = current.left;
        while (prev.right != null && prev.right != current)
          prev = prev.right;
        if (prev.right == null) {
          prev.right = current;
          current = current.left;
        } else {
          prev.right = null;
          visit(current);
          current = current.right;
        }
      }
    }
  }

  public ArrayList<Integer> recoverTree(TreeNode A) {
    morrisTraversal(A);
    return new ArrayList<Integer>(Arrays.asList(first, second));
  }

}
