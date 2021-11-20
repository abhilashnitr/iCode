package main.FAANG.TreeUtils;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxSumAnyTwoLeaves {

  int maxSum = 0;

  public static void main(String[] args) {
    Node root = new Node(2);
    root.left = new Node(4);
    root.right = new Node(5);
    root.left.left = new Node(1);
    root.left.right = new Node(6);
    root.right.right = new Node(7);
    MaxSumAnyTwoLeaves max = new MaxSumAnyTwoLeaves();

    max.getMaxSumBetLeaf(root);
    System.out.println(max.maxSum);

  }

  private int getMaxSumBetLeaf(Node root) {
    if (root == null) {
      return 0;
    }
    if (root.right == null && root.left == null) {
      return root.data;
    }

    int l = getMaxSumBetLeaf(root.left);
    int r = getMaxSumBetLeaf(root.right);

    if (root.left != null && root.right != null) {
        maxSum = Math.max(l + r + root.data,maxSum);
      return Math.max(l, r) + root.data;
    }
    return root.left != null ? l + root.data : r + root.data;
  }


  AtomicInteger max_sum = new AtomicInteger(Integer.MIN_VALUE);
  public static int findMaxSumPath(Node root, AtomicInteger max_sum)
  {
    // base case: empty tree
    if (root == null) {
      return 0;
    }

    // find the maximum sum node-to-leaf path starting from the left child
    int left = findMaxSumPath(root.left, max_sum);
    // find the maximum sum node-to-leaf path starting from the right child
    int right = findMaxSumPath(root.right, max_sum);
    // it is important to return the maximum sum node-to-leaf path starting
    // from the current node
    // case 1: left child is null
    if (root.left == null) {
      return right + root.data;
    }
    // case 2: right child is null
    if (root.right == null) {
      return left + root.data;
    }
    // find the maximum sum path "through" the current node
    int cur_sum = left + right + root.data;
    // update the maximum sum path found so far (Note that maximum sum path
    // "excluding" the current node in the subtree rooted at the current node
    // is already updated as we are doing postorder traversal)
    max_sum.set(Math.max(cur_sum, max_sum.get()));
    // case 3: both left and right child exists
    return Math.max(left, right) + root.data;
  }
}
