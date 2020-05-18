package ArrayUtils.TreeUtils;

public class NextInOrderSuccesssor {
    Node head;
    Node prev=null;

  public static void main(String[] args) {
    NextInOrderSuccesssor next=new NextInOrderSuccesssor();

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    next.connectNext(root);
    printDLL(next.head);

  }
  public static void printDLL(Node head)
  {
    Node curr = head;
    while (curr != null)
    {
      System.out.print(curr.data + " ");
      curr = curr.nextPointer;
    }
  }

  private void connectNext(Node root) {
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
