package ArrayUtils.TreeUtils;

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
    root.right.left = new Node(6);
    root.right.right = new Node(7);

   // connectNextPointer(root);
    ConnectNodes connectNodes=new ConnectNodes();
   // connectNodes.connectNextPointer(root);
    connectNodes.connectNext(root);
    printDLL(root);
    printDLL(root.left);
    printDLL(root.left.left);
  }

  private static void connectNextPointer(Node root) {
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

  private  void  connectNext(Node root) {
    if(root==null)
      return;
    connectNext(root.left);
    if(prev!=null){
      prev.nextPointer=root;
    }else {
      head=root;
    }
    prev=root;
    connectNext(root.right);
  }

}
