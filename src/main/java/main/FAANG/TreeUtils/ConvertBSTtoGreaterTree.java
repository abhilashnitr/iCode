package main.FAANG.TreeUtils;

import java.util.Stack;

//https://leetcode.com/problems/convert-bst-to-greater-tree/discuss/100516/Java-Three-O(n)-Methods%3A-Recursive-Iterative-and-Morris-Traversal
public class ConvertBSTtoGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int tmp = cur.val;
            cur.val += sum;
            sum += tmp;
            cur = cur.left;
        }
        return root;
    }
}
