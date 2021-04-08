package main.FAANG.TreeUtils;
//Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)

public class DistanceBetTwoNodes {

  static int d1 = -1;
  static int d2 = -1;
  static int dist = 0;

 static int findLevel(Node root, int k, int level)
  {
    if (root == null)
      return -1;

    if (root.key == k)
      return level;

    int l = findLevel(root.left, k, level + 1);
    return (l != -1)? l : findLevel(root.right, k, level + 1);
  }

  static Node findDistUtil(Node root, int n1, int n2, int lvl){
    if (root == null)
      return null;
    if (root.key == n1){
      d1 = lvl;
      return root;
    }
    if (root.key == n2)
    {
      d2 = lvl;
      return root;
    }
    Node left_lca = findDistUtil(root.left, n1, n2,  lvl + 1);
    Node right_lca = findDistUtil(root.right, n1, n2,  lvl + 1);
    if (left_lca != null && right_lca != null)
    {
      dist = (d1 + d2) - 2*lvl;
      return root;
    }
    return (left_lca != null)? left_lca : right_lca;
  }

  static int findDistance(Node root, int n1, int n2){
    d1 = -1;
    d2 = -1;
    dist = 0;
    Node lca = findDistUtil(root, n1, n2, 1);

    if (d1 != -1 && d2 != -1)
      return dist;
    if (d1 != -1)
    {
      dist = findLevel(lca, n2, 0);
      return dist;
    }
    if (d2 != -1)
    {
      dist = findLevel(lca, n1, 0);
      return dist;
    }
    return -1;
  }

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);

   // System.out.println("Dist(4, 5) = "+findDistance(root, 4, 5));
//    System.out.println("Dist(4, 6) = "+findDistance(root, 4, 6));
//    System.out.println("Dist(3, 4) = "+findDistance(root, 3, 4));
//    System.out.println("Dist(2, 4) = "+findDistance(root, 2, 4));
    System.out.println("Dist(8, 5) = " +findDistance(root, 5, 7));

  }

  static class Node {
    int key;
    Node left;
    Node right;
    Node nextPointer;

    public Node(int data) {
      this.key = data;
      this.left = null;
      this.right = null;
      this.nextPointer = null;
    }
  }

}
