package main.FAANG.TreeUtils;

public class DeleteNodeinaBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else { // found node to be deleted
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // node with two children, replace with the inOrder successor(minVal) in the right subtree
            root.val = getMin(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    private int getMin(TreeNode root) {
        while (root.left != null) {root = root.left;}
        return root.val;
    }

}
