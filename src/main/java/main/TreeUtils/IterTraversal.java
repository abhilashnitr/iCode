package main.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

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

    String[] ar=new String[5];
    System.out.println(ar.length);
    System.out.println();
    preOrderTraversal(root);
    postOrderTraversal(root);
    inOrderTraversal(root);
    printLevelOrder(root);
    spiralTraversal(root);
    MorisPreorderTraversal(root);
    MorisInorderTraversal(root);
    printTop(root);
    printVerticalOrder(root);
    printBoundryNode(root);

  }

  private static void printBoundryNode(Node node) {
    System.out.println("Print Boundry View");
    if (node == null)
      return;

    System.out.print(node.data + " ");
    printBoundaryLeft(node.left);
    printLeaves(node.left);
    printLeaves(node.right);
    printBoundaryRight(node.right);
    System.out.println();
  }
  private static void printLeaves(Node node)
  {
    if (node == null)
      return;

    printLeaves(node.left);
    if (node.left == null && node.right == null)
      System.out.print(node.data + " ");
    printLeaves(node.right);
  }
  private static void printBoundaryLeft(Node node)
  {
    if (node == null)
      return;
    if (node.left != null) {
      System.out.print(node.data + " ");
      printBoundaryLeft(node.left);
    }
    else if (node.right != null) {
      System.out.print(node.data + " ");
      printBoundaryLeft(node.right);
    }
  }
  private static void printBoundaryRight(Node node)
  {
    if (node == null)
      return;
    if (node.right != null) {
      printBoundaryRight(node.right);
      System.out.print(node.data + " ");
    }
    else if (node.left != null) {
      printBoundaryRight(node.left);
      System.out.print(node.data + " ");
    }

  }

  // Pair class
  static class Pair<U, V>
  {
    public final U first;   	// first field of a Pair
    public final V second;  	// second field of a Pair

    // Constructs a new Pair with specified values
    private Pair(U first, V second)
    {
      this.first = first;
      this.second = second;
    }

    // Factory method for creating a Typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
      // calls private constructor
      return new Pair<>(a, b);
    }
  }

  public static void printTop(Node root, int dist, int level,
      Map<Integer, Pair<Integer, Integer>> map)
  {
    // base case: empty tree
    if (root == null) {
      return;
    }
    // if current level is less than maximum level seen so far
    // for the same horizontal distance or horizontal distance
    // is seen for the first time, update the map
    if (!map.containsKey(dist) || level < map.get(dist).second) {
      // update value and level for current distance
      map.put(dist, Pair.of(root.data, level));
    }

    // recur for left subtree by decreasing horizontal distance and
    // increasing level by 1
    printTop(root.left, dist - 1, level + 1, map);

    // recur for right subtree by increasing both level and
    // horizontal distance by 1
    printTop(root.right, dist + 1, level + 1, map);
  }

  // Function to print the top view of given binary tree
  public static void printTop(Node root)
  {
    // create a TreeMap where
    // key -> relative horizontal distance of the node from root node and
    // value -> pair containing node's value and its level
    System.out.print("Top View :");
    Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();

    // do pre-order traversal of the tree and fill the map
    printTop(root, 0, 0, map);

    // traverse the TreeMap and print top view
    for (Pair<Integer, Integer> it: map.values()) {
      System.out.print(it.first + " ");
    }
    System.out.println();
  }
  public static void printVerticalOrder(Node root){
    System.out.println("Vertical View :");
    TreeMap<Integer, ArrayList<Integer>> m=new TreeMap<Integer, ArrayList<Integer>>();
    int hd=0;
    getVerticalOrder(m,hd,root);
    for (Map.Entry<Integer, ArrayList<Integer>> cm:m.entrySet()){
      System.out.println(cm.getValue());
    }
    System.out.println();
  }

  private static void getVerticalOrder(TreeMap<Integer, ArrayList<Integer>> m, int hd, Node root) {
    if(root==null)
      return;
    if(m.get(hd)==null){
      ArrayList<Integer> l=new ArrayList<>();
      l.add(root.data);
      m.put(hd,l);
    }else {
      ArrayList<Integer> l=m.get(hd);
      l.add(root.data);
      m.put(hd,l);
    }
    getVerticalOrder(m,hd-1,root.left);
    getVerticalOrder(m,hd+1,root.right);

  }

  public static void MorisInorderTraversal(Node root) {
    System.out.print("Morris Traversal In :");
    Node current, pre;
    if (root == null)
      return;
    current = root;
    while (current != null) {
      if (current.left == null) {
        System.out.print(current.data + " ");
        current = current.right;
      }
      else {
        /* Find the inorder predecessor of current */
        pre = current.left;
        while (pre.right != null && pre.right != current)
          pre = pre.right;

        /* Make current as right child of its inorder predecessor */
        if (pre.right == null) {
          pre.right = current;
          current = current.left;
        }
                /* Revert the changes made in the 'if' part to restore the
                    original tree i.e., fix the right child of predecessor*/
        else {
          pre.right = null;
          System.out.print(current.data + " ");
          current = current.right;
        } /* End of if condition pre->right == NULL */
      } /* End of if condition current->left == NULL*/
    } /* End of while */
    System.out.println();
  }

  public static void MorisPreorderTraversal(Node node) {
    System.out.print("Morris Traversal Pre :");
    while (node != null) {
      // If left child is null, print the current node data. Move to
      // right child.
      if (node.left == null) {
        System.out.print(node.data + " ");
        node = node.right;
      } else {
           // Find inorder predecessor
        Node current = node.left;
        while (current.right != null && current.right != node) {
          current = current.right;
        }
        // If the right child of inorder predecessor
        // already points to this node
        if (current.right == node) {
          current.right = null;
          node = node.right;
        }
        // If right child doesn't point to this node, then print
        // this node and make right child point to this node
        else {
          System.out.print(node.data + " ");
          current.right = node;
          node = node.left;
        }
      }
    }
    System.out.println();
  }

  public static void spiralTraversal(Node root) {
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

  public static void printLevelOrder(Node root)
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

  public static void inOrderTraversal(Node root) {
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

  public static void postOrderTraversal(Node root) {
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

  public static void preOrderTraversal(Node root) {
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
