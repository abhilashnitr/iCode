package ArrayUtils.TreeUtils;

public class CheckSiblings {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    CheckSiblings test=new CheckSiblings();
    System.out.println(test.checkSiblings(root,root.right.left,root.right.right));

  }

  private boolean checkSiblings(Node node, Node a, Node b) {
    if (node == null) {
      return false;
    }
    return (node.left == a && node.right == b)
        || (node.left == b && node.right == a)
        || checkSiblings(node.left, a, b)
        || checkSiblings(node.right, a, b);
  }

}
