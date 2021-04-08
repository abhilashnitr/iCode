package main.FAANG.TreeUtils;

public class Diameter {

  public static void main(String args[])
  {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    diameter(root);

  }

  public static int diameterOpt(Node root, Height height)
  {
    Height lh = new Height(), rh = new Height();
    if (root == null)
    {
      height.h = 0;
      return 0; /* diameter is also 0 */
    }
    int ldiameter = diameterOpt(root.left, lh);
    int rdiameter = diameterOpt(root.right, rh);
    height.h = Math.max(lh.h, rh.h) + 1;
    return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
  }

    public static int diameter(Node root)
  {
    if (root == null)
      return 0;

    int lheight = height(root.left);
    int rheight = height(root.right);

    int ldiameter = diameter(root.left);
    int rdiameter = diameter(root.right);


    return Math.max(lheight + rheight + 1,
        Math.max(ldiameter, rdiameter));

  }

   static int height(Node node)
  {
    if (node == null)
      return 0;
    return (1 + Math.max(height(node.left), height(node.right)));
  }

}

class Height
{
  int h;
}