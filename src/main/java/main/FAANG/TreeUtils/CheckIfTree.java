package main.FAANG.TreeUtils;

public class CheckIfTree {

  void mirror(Node node)
  {
    if (node == null)
      return;
    else {
      Node temp;

      /* do the subtrees */
      mirror(node.left);
      mirror(node.right);

      /* swap the pointers in this node */
      temp = node.left;
      node.left = node.right;
      node.right = temp;
    }
  }

  boolean isStructSame(Node a, Node b)
  {
    if (a == null && b == null)
      return true;
    if (a != null && b != null
        && isStructSame(a.left, b.left)
        && isStructSame(a.right, b.right))
      return true;

    return false;
  }

  boolean isFoldable(Node node)
  {
    boolean res;

    if (node == null)
      return true;

    mirror(node.left);

    res = isStructSame(node.left, node.right);

    mirror(node.left);

    return res;
  }

  boolean IsFoldableUtil(Node n1, Node n2)
  {

    if (n1 == null && n2 == null)
      return true;


    if (n1 == null || n2 == null)
      return false;


    return IsFoldableUtil(n1.left, n2.right)
        && IsFoldableUtil(n1.right, n2.left);
  }

  boolean isMirror(Node node1, Node node2)
  {
    if (node1 == null && node2 == null)
      return true;

    if (node1 != null && node2 != null && node1.data == node2.data)
      return (isMirror(node1.left, node2.right)
          && isMirror(node1.right, node2.left));


    return false;
  }



}
