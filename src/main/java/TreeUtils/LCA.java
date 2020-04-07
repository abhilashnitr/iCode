package TreeUtils;

public class LCA {

  static boolean v1 = false, v2 = false;
  static Node root;
  public static void main(String args[])
  {

     root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    System.out.println("LCA(4, 5) = " +
        findLCA(root,4, 5).data);
    System.out.println("LCA(4, 6) = " +
        findLCA(root,4, 6).data);
    System.out.println("LCA(3, 4) = " +
        findLCA(root,3, 4).data);
    System.out.println("LCA(2, 4) = " +
        findLCA(root,2, 4).data);

    Node lca = findLCA(4, 5);
    if (lca != null)
      System.out.println("LCA(4, 5) = " + lca.data);
    else
      System.out.println("Keys are not present");
    Node lca1 = findLCA(4, 8);
    if (lca1 != null)
      System.out.println("LCA(4, 8) = " + lca.data);
    else
      System.out.println("Keys are not present");
  }

  static Node findLCA(int n1, int n2)
  {
    // Initialize n1 and n2 as not visited
    v1 = false;
    v2 = false;

    // Find lca of n1 and n2 using the technique discussed above
    Node lca = findLCAUtil(root, n1, n2);

    // Return LCA only if both n1 and n2 are present in tree
    if (v1 && v2)
      return lca;

    // Else return NULL
    return null;
  }

  static Node findLCAUtil(Node node, int n1, int n2)
  {
    if (node == null)
      return null;
    Node temp=null;
    if (node.data == n1)
    {
      v1 = true;
      temp = node;
    }
    if (node.data == n2)
    {
      v2 = true;
      temp = node;
    }
    if (temp != null)
      return temp;

    Node left_lca = findLCAUtil(node.left, n1, n2);
    Node right_lca = findLCAUtil(node.right, n1, n2);


    if (left_lca != null && right_lca != null)
      return node;
    return (left_lca != null) ? left_lca : right_lca;
  }


    private static Node findLCA(Node node, int n1, int n2) {
    if (node == null)
      return null;
    if (node.data == n1 || node.data == n2)
      return node;
    Node left_lca = findLCA(node.left, n1, n2);
    Node right_lca = findLCA(node.right, n1, n2);

    if (left_lca!=null && right_lca!=null)
      return node;
    return (left_lca != null) ? left_lca : right_lca;

  }

}
