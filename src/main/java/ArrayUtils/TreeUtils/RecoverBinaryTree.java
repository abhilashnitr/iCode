package ArrayUtils.TreeUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class RecoverBinaryTree {
  private static Integer first, second;
  private static Node prev;

  private static void visit(Node current) {
    if (prev != null && prev.data > current.data) {
      first = current.data;
      if (second == null)
        second = prev.data;
    }
    prev = current;
  }

  private static void morrisTraversal(Node root) {
    Node current = root;
    while (current != null) {
      if (current.left == null) {
        visit(current);
        current = current.right;
      } else {
        Node prev = current.left;
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

  public static ArrayList<Integer> recoverTree(Node A) {
    morrisTraversal(A);
    return new ArrayList<Integer>(Arrays.asList(first, second));
  }

  public static void main(String[] args) {
    Node root = new Node(6);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(1);
    root.left.right = new Node(10);
    root.right.right = new Node(12);
    root.right.left = new Node(7);

    recoverTree(root);
    System.out.println(first+" "+second);
  }

}
