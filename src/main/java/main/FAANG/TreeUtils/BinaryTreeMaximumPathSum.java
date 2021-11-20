package main.FAANG.TreeUtils;

public class BinaryTreeMaximumPathSum {

    static int maxValue;

    public static int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private static int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(15);
        root.left=new TreeNode(-77);
        root.right=new TreeNode(3);

        System.out.println(maxPathSum(root));
    }
}
