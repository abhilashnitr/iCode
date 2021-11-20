package main.FAANG.TreeUtils;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        FindLeavesofBinaryTree findLeaves=new FindLeavesofBinaryTree();
        System.out.println(findLeaves.findLeaves(root));
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    // traverse the tree bottom-up recursively
    private int helper(List<List<Integer>> list, TreeNode root){
        if(root==null)
            return -1;

        int left = helper(list, root.left);
        int right = helper(list, root.right);
        int curr = Math.max(left, right)+1;

        // the first time this code is reached is when curr==0,
        //since the tree is bottom-up processed.
        if(list.size()<=curr){
            list.add(new ArrayList<>());
        }

        list.get(curr).add(root.val);

        return curr;
    }
}
