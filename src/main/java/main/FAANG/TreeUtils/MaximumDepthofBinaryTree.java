package main.FAANG.TreeUtils;

public class MaximumDepthofBinaryTree {

    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int ldepth=maxDepth(root.left);
        int rdepth=maxDepth(root.right);

        return 1+Math.max(ldepth,rdepth);
    }

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ldepth=minDepth(root.left);
        int rdepth=minDepth(root.right);

        if(ldepth==0||rdepth==0)
            return ldepth+rdepth+1;
        return 1+Math.min(ldepth,rdepth);
    }
}
