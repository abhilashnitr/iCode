package main.FAANG.TreeUtils;

//You are given the root of a binary tree with n nodes where each node in the tree has node.val coins and there are n
// coins total.
//In one move, we may choose two adjacent nodes and move one coin from one node to another. (A move may be from parent
// to child, or from child to parent.)
//Return the number of moves required to make every node have exactly one coin.
public class DistributeCoins {

    int ans;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans += Math.abs(L) + Math.abs(R);
        return node.val + L + R - 1;
    }
}
