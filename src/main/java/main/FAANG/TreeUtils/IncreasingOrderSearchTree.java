package main.FAANG.TreeUtils;

import java.util.Stack;

//Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now
// the root of the tree, and every node has no left child and only one right child.
public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = null, pre = null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (head == null) {
                head = cur;
            }
            cur.left = null;
            if (pre != null) {
                pre.right = cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return head;
    }


    TreeNode prev=null, head=null;
    public TreeNode increasingBST2(TreeNode root) {
        if(root==null) return null;
        increasingBST(root.left);
        if(prev!=null) {
            root.left=null; // we no  longer needs the left  side of the node, so set it to null
            prev.right=root;
        }
        if(head==null) head=root; // record the most left node as it will be our root
        prev=root; //keep track of the prev node
        increasingBST(root.right);
        return head;
    }
}
