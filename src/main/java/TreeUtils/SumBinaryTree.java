package TreeUtils;

import LeetCode.SameTree.TreeNode;
import java.util.HashSet;
import java.util.Set;

public class SumBinaryTree {
    public int t2Sum(TreeNode A, int B) {
      Set<Integer> set = new HashSet<>();
      return inOrder(A, B, set);
    }

    private int inOrder(TreeNode root, int k, Set<Integer> set) {
      if (root == null) return 0;

      int left = inOrder(root.left, k, set);
      if (left ==1 ) return left;
      if (set.contains(k-root.val)) return 1;
      set.add(root.val);
      return inOrder(root.right, k, set);


    }

}
