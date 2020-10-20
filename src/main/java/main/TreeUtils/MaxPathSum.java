package main.TreeUtils;

public class MaxPathSum {
  int maxSum = 0;

  public int maxSumPath(Node node) {
    if (node == null) {
      return 0;
    }

    if(node.left == null && node.right == null) {
      return node.data;
    }

    int l = maxSumPath(node.left);
    int r = maxSumPath(node.right);

    int max_one = Math.max(node.data,  node.data + Math.max(l, r) );

    int max_two = Math.max(max_one, l + r + node.data);

    maxSum = Math.max(maxSum, max_two);

    return max_one;
  }

  public static void main(String[] args) {
     Node root;
    root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(-4);
    root.left.right = new Node(-5);
    root.right.left = new Node(-6);
    root.right.right = new Node(-7);
    MaxPathSum mx=new MaxPathSum();
    System.out.println(mx.maxSumPath(root));
  }


}
