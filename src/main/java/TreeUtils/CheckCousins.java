package TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCousins {

  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.left.left = new Node(9);
    root.left.right = new Node(5);
    root.left.right.left = new Node(6);
    root.left.right.right = new Node(7);
    root.left.right.right.right = new Node(10);
    root.left.right.right.right.left = new Node(11);
    root.right.right = new Node(8);
    System.out.println(areCousins1(root,4,8));
    System.out.println(areCousins1(root,2,2));

  }
  public static boolean areCousins1(Node root, int data1, int data2) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    int tempLevel = 1;
    int level = 0;
    boolean found1 = false;
    boolean found2 = false;
    Node parent1 = null;
    Node parent2 = null;
    while (!queue.isEmpty()) {
      tempLevel = queue.size();
      while (tempLevel > 0) {
        root = queue.poll();
        if (root.left != null) {
          if (root.left.data == data1) {
            found1 = true;
            parent1 = root;
          } else if (root.left.data == data2) {
            found2 = true;
            parent2 = root;
          } else {
            queue.add(root.left);

          }
        }
        if (root.right != null) {
          if (root.right.data == data1) {
            found1 = true;
            parent1 = root;
          } else if (root.right.data == data2) {
            found2 = true;
            parent2 = root;
          } else {
            queue.add(root.right);

          }
        }
        tempLevel--;
      }
      if (found1 && found2 && parent1 != parent2) {
        return true;
      } else if (found1 || found2) {
        return false;
      }

    }
    return false;
  }

}
