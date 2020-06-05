package main.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class DifferentViewOfTree {

  public static void main(String[] args) {
    Node root= new Node(1);
    root.left=new Node(2);
    root.right=new Node(3);
    root.left.left=new Node(4);
    root.left.right=new Node(5);
    root.right.left=new Node(6);
    root.right.right=new Node(7);

    printleftView(root);
    printRightView(root);

    connectTreeNode(root);
  }

  public void connectTree(Node root)
  {
    while(root != null)
    {
      Node ptr = root;
      while(ptr != null)
      {
        if(ptr.left != null)
          ptr.left.nextPointer = ptr.right;
        if(ptr.right != null && ptr.nextPointer != null)
          ptr.right.nextPointer = ptr.nextPointer.left;
        ptr = ptr.nextPointer;
      }
      root = root.left;
    }
  }


  private static void connectTreeNode(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    Node temp=null;
    while(!q.isEmpty()){
      int n=q.size();
      for(int i=0;i<n;i++){
        Node prev=temp;
        temp=q.poll();

        if(i>0)
          prev.nextPointer=temp;
        if(temp.left!=null)
          q.add(temp.left);
        if(temp.right!=null)
          q.add(temp.right);
      }
      temp.nextPointer=null;
    }
  }

  private static void printRightView(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root); // adding nodes to tehe queue
    System.out.print("Right Order ");
    while (!q.isEmpty()){
      int n=q.size();
      for(int i=0;i<n;i++){
        Node temp;
        temp = q.poll();
        if(i==n-1){
          System.out.print(temp.data);
        }
        if(temp.left!=null)
          q.add(temp.left);
        if(temp.right!=null)
          q.add(temp.right);
      }
    }
    System.out.println();
  }

  private static void printleftView(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root); // adding nodes to tehe queue
    System.out.print("Left Order ");
    while (!q.isEmpty()){
      int n=q.size();
     for(int i=0;i<n;i++){

         Node temp=q.poll();
       if(i==0)
         System.out.print(temp.data);
         if(temp.left!=null)
           q.add(temp.left);
         if(temp.right!=null)
           q.add(temp.right);

     }
    }
    System.out.println();
  }


}
