package main.FAANG.TreeUtils;

import java.util.Stack;

public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        int sum = 0;
        while (!stk.isEmpty()) {
            TreeNode n = stk.pop();
            if (n == null) { continue; }
            if (n.val > L) { stk.push(n.left); } // left child is a possible candidate.
            if (n.val < R) { stk.push(n.right); } // right child is a possible candidate.
            if (L <= n.val && n.val <= R) { sum += n.val; }
        }
        return sum;
    }

    public int rangeSumBST2(TreeNode root, int L, int R) {
        if(root == null) return 0;
        if(root.val > R) return rangeSumBST(root.left, L, R);
        if(root.val < L) return rangeSumBST(root.right, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }

    int ans = 0;

    public int rangeSumBST3(TreeNode root, int low, int high) {
        util(root, low, high);
        return ans;
    }

    void util(TreeNode root, int low, int high){
        if(root == null){
            return;
        }
        if(low <= root.val &&  root.val <= high){
            ans += root.val;
        }
        util(root.left, low, high);
        util(root.right, low, high);
    }
}
