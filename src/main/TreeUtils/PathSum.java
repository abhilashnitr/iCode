package main.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * Time complexity O(n)
 *
 * https://leetcode.com/problems/path-sum/
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSum {

  public static void main(String[] args) {
    Node root= new Node(5);
    root.left=new Node(4);
    root.right=new Node(8);
    root.left.left=new Node(11);
    root.left.left.left=new Node(7);
    root.left.left.right=new Node(2);
    root.right.left=new Node(13);
    root.right.right=new Node(4);
    root.right.right.left=new Node(5);
    root.right.right.right=new Node(1);
    System.out.println(pathSum(root,22));
    System.out.println(hasPathSum(root,22));
    System.out.println(printPath(root));
  }

  private static List<List<Integer>> printPath(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    printLeafPathUtils(root, result, current);
    return result;
  }

  public static List<List<Integer>> pathSum(Node root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    pathSumUtil(root, sum, result, current);
    //printLeafPathUtils(root, result, current);
    return result;
  }

  private static void printLeafPathUtils(Node root, List<List<Integer>> result, List<Integer> currentPath) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {

        currentPath.add(root.data);
        result.add(new ArrayList<>(currentPath));
        currentPath.remove(currentPath.size() - 1);

      return;
    }
    currentPath.add(root.data);
    printLeafPathUtils(root.left, result, currentPath);
    printLeafPathUtils(root.right, result, currentPath);
    currentPath.remove(currentPath.size() - 1);
  }

  private static void pathSumUtil(Node root, int sum, List<List<Integer>> result, List<Integer> currentPath) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      if (root.data == sum) {
        currentPath.add(root.data);
        result.add(new ArrayList<>(currentPath));
        currentPath.remove(currentPath.size() - 1);
      }
      return;
    }
    currentPath.add(root.data);
    pathSumUtil(root.left, sum - root.data, result, currentPath);
    pathSumUtil(root.right, sum - root.data, result, currentPath);
    currentPath.remove(currentPath.size() - 1);
  }

  public static boolean hasPathSum(Node root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return root.data == sum;
    }
    return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
  }

}
