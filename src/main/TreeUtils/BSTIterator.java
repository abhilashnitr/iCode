package main.TreeUtils;

import java.util.Stack;

/*
Implement an iterator over a binary search tree (BST).
Your iterator will be initialized with the root node
of a BST. Calling next() will return the next smallest
number in the BST. Note: next() and hasNext() should
run in average O(1) time and uses O(h) memory, where
h is the height of the tree.
*/
public class BSTIterator {

  Stack<Node> stack;

  public BSTIterator(Node root) {
    stack = new Stack<Node>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }


  public boolean hasNext() {
    return !stack.isEmpty();
  }

  public int next() {
    Node node = stack.pop();
    int result = node.data;
    if (node.right != null) {
      node = node.right;
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }
    return result;
  }

  public static Node insert(Node root, int key)
  {
    if (root == null) {
      return new Node(key);
    }
    if (key < root.data) {
      root.left = insert(root.left, key);
    }
    else {
      root.right = insert(root.right, key);
    }
    return root;
  }


  public static void main(String[] args) {
    int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

    Node root = null;
    for (int key : keys) {
      root = insert(root, key);
    }

    BSTIterator itr=new BSTIterator(root);
    while (itr.hasNext()) {
      System.out.println(itr.next());
    }

  }

}
