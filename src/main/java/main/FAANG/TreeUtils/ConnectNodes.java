package main.FAANG.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodes {
  Node head;
  Node prev=null;

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
   // root.right.left = new Node(6);
    root.right.right = new Node(7);

   // connectNextPointer(root);
    ConnectNodes connectNodes=new ConnectNodes();
    //connectNodes.connectNextPointer(root);
   // connectNodes.connectNext(root);
    connectNodes.connect3(root);
    printDLL(root);
    printDLL(root.left);
    printDLL(root.left.left);
  }

  public Node connect1(Node root) {

    Node head = null; //head of the next level
    Node prev = null; //the leading node on the next level
    Node cur = root;  //current node of current level

    while (cur != null) {

      while (cur != null) { //iterate on the current level
        //left child
        if (cur.left != null) {
          if (prev != null) {
            prev.nextPointer = cur.left;
          } else {
            head = cur.left;
          }
          prev = cur.left;
        }
        //right child
        if (cur.right != null) {
          if (prev != null) {
            prev.nextPointer = cur.right;
          } else {
            head = cur.right;
          }
          prev = cur.right;
        }
        //move to next node
        cur = cur.nextPointer;
      }

      //move to next level
      cur = head;
      head = null;
      prev = null;
    }

    return root;

  }


  private static void connect2(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    Node temp = null;
    while (!q.isEmpty()){
      int n = q.size();
      for(int i=0;i<n;i++){
        Node previous = temp;
        temp = q.poll();
        if(i>0)
          previous.nextPointer=temp;
        if (temp.left != null)
          q.add(temp.left);

        if (temp.right != null)
          q.add(temp.right);
      }
      temp.nextPointer = null;
    }
  }

  public static void printDLL(Node head)
  {
    Node curr = head;
    while (curr != null)
    {
      System.out.print(curr.data + " ");
      curr = curr.nextPointer;
    }
    System.out.println();
  }

  private  void  connect3(Node root) {
    if(root==null)
      return;
    connect3(root.left);
    if(prev!=null){
      prev.nextPointer=root;
    }else {
      head=root;
    }
    prev=root;
    connect3(root.right);
  }

  public Node connect4(Node root) {
    if(root==null)
      return null;
    Queue<Node> Q1 = new LinkedList<Node>();
    Q1.offer(root);
    Queue<Node> Q2 = new LinkedList<Node>();
    while(Q1.size() > 0){
      while(Q1.size() > 0){
        Node temp = Q1.poll();
        if(Q1.size()>0){
          temp.nextPointer = Q1.peek();
        }
        else{
          temp.nextPointer = null;
        }
        if(temp.left!=null)
          Q2.offer(temp.left);
        if(temp.right!=null)
          Q2.offer(temp.right);
      }
      Q1 = Q2;
      Q2 = new LinkedList<Node>();
    }
    return root;
  }

  public Node connect5(Node root) {
    if (root == null)
      return null;
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(root);
    queue.offer(null);
    while (!queue.isEmpty()){
      Node  p=queue.poll();
      if(p!=null)
      {
        p.nextPointer=queue.peek();
        if(p.left!=null)
          queue.offer(p.left);
        if(p.right!=null)
          queue.offer(p.right);
      }
      else
      {
        if(!queue.isEmpty())
          queue.offer(null);
      }
    }
    return root;
  }
  public Node connect(Node root) {
    if (root == null) {
      return root;
    }
    Queue<Node> Q = new LinkedList<Node>();
    Q.add(root);

    // Outer while loop which iterates over
    // each level
    while (Q.size() > 0) {

      // Note the size of the queue
      int size = Q.size();

      // Iterate over all the nodes on the current level
      for (int i = 0; i < size; i++) {

        // Pop a node from the front of the queue
        Node node = Q.poll();

        // This check is important. We don't want to
        // establish any wrong connections. The queue will
        // contain nodes from 2 levels at most at any
        // point in time. This check ensures we only
        // don't establish next pointers beyond the end
        // of a level
        if (i < size - 1) {
          node.nextPointer = Q.peek();
        }

        // Add the children, if any, to the back of
        // the queue
        if (node.left != null) {
          Q.add(node.left);
        }
        if (node.right != null) {
          Q.add(node.right);
        }
      }
    }

    // Since the tree has now been modified, return the root node
    return root;
  }
}
