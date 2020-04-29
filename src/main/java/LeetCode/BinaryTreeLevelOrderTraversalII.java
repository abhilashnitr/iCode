package LeetCode;

import LeetCode.SameTree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    dfs(root, ans, 0);
    return ans;
  }

  public void dfs(TreeNode root, List<List<Integer>> ans, int level){
    if (root == null) return;
    if (ans.size() == level) ans.add(0, new ArrayList<>());

    ans.get(ans.size() - 1 - level).add(root.val);
    dfs(root.left, ans, level + 1);
    dfs(root.right, ans, level + 1);
  }

}
