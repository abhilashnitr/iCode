package ArrayUtils.TreeUtils;

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

}
