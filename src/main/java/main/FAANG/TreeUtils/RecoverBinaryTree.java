package main.FAANG.TreeUtils;

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
    System.out.println(first + " " + second);
  }


  Node firstElement = null;
  Node secondElement = null;
  // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
  Node prevElement = new Node(Integer.MIN_VALUE);

  public void recoverTree2(Node root) {

    // In order traversal to find the two elements
    traverse(root);

    // Swap the values of the two nodes
    int temp = firstElement.data;
    firstElement.data = secondElement.data;
    secondElement.data = temp;
  }

  private void traverse(Node root) {

    if (root == null)
      return;

    traverse(root.left);

    // Start of "do some business",
    // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
    if (firstElement == null && prevElement.data >= root.data) {
      firstElement = prevElement;
    }

    // If first element is found, assign the second element to the root (refer to 2 in the example above)
    if (firstElement != null && prevElement.data >= root.data) {
      secondElement = root;
    }
    prevElement = root;

    // End of "do some business"

    traverse(root.right);


  }

}