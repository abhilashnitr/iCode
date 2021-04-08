package main.FAANG.TreeUtils;

public class BST {

  public static Node insert(Node root, int key)
  {
    if (root == null) {
      return new Node(key);
    }
    if (key < root.data) {
      root.left = insert(root.left, key);
    }
    else {
      root.right = insert(root.right, key);
    }
    return root;
  }

  public static Node findMinimum(Node root)
  {
    while (root.left != null) {
      root = root.left;
    }

    return root;
  }

  public static Node findSuccessor(Node root, Node succ, int key)
  {
    // base case
    if (root == null) {
      return null;
    }
    if (root.data == key)
    {
      if (root.right != null) {
        return findMinimum(root.right);
      }
      return succ;
    }
    else if (key < root.data)
    {
      // update successor to current node before recursing in
      // left subtree
      succ = root;
      return findSuccessor(root.left, succ, key);
    }
    else {
      return findSuccessor(root.right, succ, key);
    }

  }

  public static void main(String[] args)
  {
		/* Construct below tree
				   15
				 /	\
				/	  \
			   10	   20
			  /  \	 /  \
			 /	\   /	\
			8	 12 16	25
		*/

    int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

    Node root = null;
    for (int key : keys) {
      root = insert(root, key);
    }

    // find in-order successor for each key
    for (int key : keys)
    {
      Node prec = findSuccessor(root, null, key);

      if (prec != null) {
        System.out.println("Successor of node " + key + " is "
            + prec.data);
      } else {
        System.out.println("Successor doesn't exists for node "
            + key);
      }
    }
  }

}
