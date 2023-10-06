package main.FAANG.TreeUtils;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    TreeNode nextPointer;

    public TreeNode(int data) {
        this.val = data;
        this.left = null;
        this.right = null;
        this.nextPointer=null;
    }


}
