package main.TreeUtils;

import java.util.*;

public class NodeAtKDistance {

  public static void main(String[] args) throws java.lang.Exception {
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
    NodeAtKDistance i = new NodeAtKDistance();
    System.out.print("Nodes at distance '3' from Node '5' are : ");
    System.out.println(i.distanceK(root, root.left.right, 3));
  }

    List<Integer> ans;
    Node target;
    int K;
    public List<Integer> distanceK(Node root, Node target, int K) {
      ans = new LinkedList();
      this.target = target;
      this.K = K;
      dfs(root);
      return ans;
    }

    // Return vertex distance from node to target if exists, else -1
    // Vertex distance: the number of vertices on the path from node to target
    public int dfs(Node node) {
      if (node == null)
        return -1;
      else if (node == target) {
        subtree_add(node, 0);
        return 1;
      } else {
        int L = dfs(node.left), R = dfs(node.right);
        if (L != -1) {
          if (L == K) ans.add(node.data);
          subtree_add(node.right, L + 1);
          return L + 1;
        } else if (R != -1) {
          if (R == K) ans.add(node.data);
          subtree_add(node.left, R + 1);
          return R + 1;
        } else {
          return -1;
        }
      }
    }

    // Add all nodes 'K - dist' from the node to answer.
    public void subtree_add(Node node, int dist) {
      if (node == null) return;
      if (dist == K)
        ans.add(node.data);
      else {
        subtree_add(node.left, dist + 1);
        subtree_add(node.right, dist + 1);
      }
    }

    /*
Traverse every node with a depth first search dfs. We'll add all nodes x to the answer such that node is the node on the path from x to target that is closest to the root.

To help us, dfs(node) will return the distance from node to the target. Then, there are 4 cases:

If node == target, then we should add nodes that are distance K in the subtree rooted at target.

If target is in the left branch of node, say at distance L+1, then we should look for nodes that are distance K - L - 1 in the right branch.

If target is in the right branch of node, the algorithm proceeds similarly.

If target isn't in either branch of node, then we stop.

In the above algorithm, we make use of the auxillary function subtree_add(node, dist) which adds the nodes in the subtree rooted at node that are distance K - dist from the given node.

    */
}
