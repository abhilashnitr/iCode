package TreeUtils;

import java.util.Stack;

public class KthSmallBST {

  // Recursive function to insert a key into BST
  public static Node insert(Node root, int key)
  {
    // if the root is null, create a new node and return it
    if (root == null) {
      return new Node(key);
    }

    // if given key is less than the root node, recur for left subtree
    if (key < root.data) {
      root.left = insert(root.left, key);
    }

    // if given key is more than the root node, recur for right subtree
    else {
      root.right = insert(root.right, key);
    }

    return root;
  }

  public static void main(String[] args) {
    Node root=new Node(10);
    root.left=new Node(5);
    root.right=new Node(15);
    root.left.left=new Node(3);
    root.left.right=new Node(7);
    root.right.left=new Node(13);
    root.right.right=new Node(17);

    IterTraversal.inOrderTraversal(root);
    inOrderTraversal(root,2);
  }

  public static void inOrderTraversal(Node root,int k) {
    Stack<Node> stack = new Stack();
    Node curr=root;
    int ksmall=Integer.MIN_VALUE;
    int c=0;
    System.out.print("Inorder  :");
    while(curr!=null || !stack.empty()){
      while(curr!=null){
        stack.push(curr);
        curr=curr.left;
      }
      curr = stack.pop();
      c++;
      if(c==k)ksmall=curr.data;
      System.out.print(curr.data + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
      curr = curr.right;
    }
    System.out.println();
    System.out.println("Kth Smallest Element is :"+ksmall);
  }

}
