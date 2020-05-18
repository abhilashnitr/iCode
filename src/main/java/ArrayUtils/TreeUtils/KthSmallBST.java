package ArrayUtils.TreeUtils;

import java.util.Stack;

public class KthSmallBST {

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
