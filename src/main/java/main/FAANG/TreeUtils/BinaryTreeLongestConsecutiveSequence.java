package main.FAANG.TreeUtils;

//Given a binary tree, find the length of the longest consecutive sequence path.
//
//The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child
// connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
public class BinaryTreeLongestConsecutiveSequence {

    private int result = Integer.MIN_VALUE;

    public int longestConsecutive(TreeNode root) {

        if(root == null)

            return 0;

        dfs(root, 0, root);

        return result;

    }

    private void dfs(TreeNode root, int cur, TreeNode pre) {

        if(root == null)

            return;

        if(root.val == pre.val+1)

            cur++;

        else

            cur = 1;

        result = Math.max(result, cur);

        dfs(root.left, cur, root);

        dfs(root.right, cur, root);

    }


    private  void helper(TreeNode root,int count){
        if(root==null)
            return;
        result=Math.max(count,result);

        if(root.left!=null)
            helper(root.left,root.left.val-root.val==1?count+1:1);
        if(root.right!=null)
            helper(root.right,root.right.val-root.val==1?count+1:1);
    }
}
