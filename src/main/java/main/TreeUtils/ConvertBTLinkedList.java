package main.TreeUtils;

public class ConvertBTLinkedList {
Node prev=null;
Node head;
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    ConvertBTLinkedList convertBTLinkedList=new ConvertBTLinkedList();
    root = convertBTLinkedList.convert(root);
    printDLL(convertBTLinkedList.head);
  }
  public static void printDLL(Node head)
  {
    Node curr = head;
    while (curr != null)
    {
      System.out.print(curr.data + " ");
      curr = curr.right;
    }
  }

  private  Node convert(Node curr) {

    if (curr == null) {
      return head;
    }
    convert(curr.left);
    if (prev != null)
    {
      // set current node's left child to prev
      curr.left = prev;
      // make prev's right child as curr
      prev.right = curr;
    }else {
      head = curr;
    }
    prev = curr;
    return convert(curr.right);
  }



}
