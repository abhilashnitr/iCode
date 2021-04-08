package main.FAANG.TreeUtils;

import java.util.Stack;

//https://medium.com/@fabianterh/iteratively-solving-flatten-binary-tree-to-linked-list-in-place-50ac7825f75b
//https://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
public class FlattenABinarytree {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(5);
    root.left.left = new Node(3);
    root.left.right = new Node(4);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    root.right.left.right = new Node(8);
    flattenItrative(root);

  }
  /*public static void printDLL(Node head)
  {
    Node curr = head;
    while (curr != null)
    {
      System.out.print(curr.data + " ");
      curr = curr.right;
    }
  }


  private static Node curr;
  public static void flatten(Node root) {
    if (root == null) {
      return;
    } else {
      curr = root;
    }
    helper(root);
  }

  private static void helper(Node root) {
    if (root == null) return;
    Node l = root.left;
    Node r = root.right;
    root.left = null;
    root.right =  null;
    if (curr != root) {
      curr.right = root;
      curr = root;
    }
    helper(l);
    helper(r);
  }

  public static void flatten2(Node root) {
    if (root == null) return;

    helper2(root, null);
  }

  private static Node helper2(Node root, Node last) {
    if (root == null) return last;
    if (last != null) last.right = root;

    Node l = root.left;
    Node r = root.right;
    root.left = null;
    root.right = null;
    Node newLast = helper2(l, root);
    return helper2(r, newLast);
  }*/
  public static void flattenItrative(Node root) {
    Stack<Node> stack = new Stack<Node>();
    Node p = root;
    while(p != null || !stack.empty()){
      if(p.right != null){
        stack.push(p.right);
      }
      if(p.left != null){
        p.right = p.left;
        p.left = null;
      }else if(!stack.empty()){
        Node temp = stack.pop();
        p.right=temp;
      }

      p = p.right;
    }
  }

  private TreeNode prev = null;

  public void flatten(TreeNode root) {
    if (root == null)
      return;
    flatten(root.right);
    flatten(root.left);
    root.right = prev;
    root.left = null;
    prev = root;
  }

  public void flatten2(TreeNode root) {
    if (root == null) return;

    TreeNode left = root.left;
    TreeNode right = root.right;

    root.left = null;

    flatten2(left);
    flatten2(right);

    root.right = left;
    TreeNode cur = root;
    while (cur.right != null) cur = cur.right;
    cur.right = right;
  }
}
