package TreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IterTraversal {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.left.left = new Node(9);
    root.left.right = new Node(5);
    root.left.right.left = new Node(6);
    root.left.right.right = new Node(7);
    root.left.right.right.right = new Node(10);
    root.left.right.right.right.left = new Node(11);
    root.right.right = new Node(8);

    preOrderTraversal(root);
    postOrderTraversal(root);
    inOrderTraversal(root);
    printLevelOrder(root);
    spiralTraversal(root);
  }

  private static void spiralTraversal(Node root) {
    Stack<Node> s1 = new Stack<Node>();
    Stack<Node> s2 = new Stack<Node>();
    System.out.print("SpiralOrder :");
    s1.push(root);
    while(!s1.empty() || !s2.empty()){
      while (!s1.empty()) {
        Node temp = s1.peek();
        s1.pop();
        System.out.print(temp.data + " ");
        if (temp.right != null)
          s2.push(temp.right);
        if (temp.left != null)
          s2.push(temp.left);
      }
      while (!s2.empty()) {
        Node temp = s2.peek();
        s2.pop();
        System.out.print(temp.data + " ");
        if (temp.left != null)
          s1.push(temp.left);
        if (temp.right != null)
          s1.push(temp.right);
      }
    }
    System.out.println();
  }

  private static void printLevelOrder(Node root)
  {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    System.out.print("LevelOrder :");
    while (!queue.isEmpty())
    {

      Node tempNode = queue.poll();
      System.out.print(tempNode.data + " ");
      /*Enqueue left child */
      if (tempNode.left != null) {
        queue.add(tempNode.left);
      }
      /*Enqueue right child */
      if (tempNode.right != null) {
        queue.add(tempNode.right);
      }
    }
    System.out.println();
  }

  private static void inOrderTraversal(Node root) {
    Stack<Node> stack = new Stack();
    Node curr=root;
    System.out.print("Inorder  :");
    while(curr!=null || !stack.empty()){
       while(curr!=null){
         stack.push(curr);
         curr=curr.left;
       }
      curr = stack.pop();

      System.out.print(curr.data + " ");

            /* we have visited the node and its
               left subtree.  Now, it's right
               subtree's turn */
      curr = curr.right;
    }
    System.out.println();
  }

  private static void postOrderTraversal(Node root) {
    Stack<Node> stack = new Stack();
    stack.push(root);
    System.out.print("PostOrder :");

    // create another stack to store post-order traversal
    Stack<Integer> out = new Stack();

    // run till stack is not empty
    while (!stack.empty())
    {
      // we pop a node from the stack and push the data to output stack
      Node curr = stack.pop();
      out.push(curr.data);
      // push left and right child of popped node to the stack
      if (curr.left != null) {
        stack.push(curr.left);
      }

      if (curr.right != null) {
        stack.push(curr.right);
      }
    }

    // print post-order traversal
    while (!out.empty()) {
      System.out.print(out.pop() + " ");
    }
    System.out.println();

  }

  private static void preOrderTraversal(Node root) {
    Stack<Node> st=new Stack<>();
    st.push(root);
    System.out.print("PreOrder :");
    while(!st.empty()){
      System.out.print(st.peek().data+" ");
      Node data=st.pop();
      if(data.right!=null)
        st.push(data.right);
      if(data.left!=null)
        st.push(data.left);
    }
    System.out.println();
  }

  // Recursive function to perform post-order traversal of the tree
  public static void postorder(Node root)
  {
    // return if the current node is empty
    if (root == null) {
      return;
    }

    // Traverse the left subtree
    postorder(root.left);

    // Traverse the right subtree
    postorder(root.right);

    // Display the data part of the root (or current node)
    System.out.print(root.data + " ");
  }

}
