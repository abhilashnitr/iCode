package main.FAANG.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

//Given the root of a binary tree, determine if it is a complete binary tree.
//
//In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level
//are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
public class CheckCompletenessofaBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;

        // Create an empty queue
        Queue<TreeNode> queue =new LinkedList<>();

        // Create a flag variable which will be set true
        // when a non full node is seen
        boolean flag = false;

        // Do level order traversal using queue.
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode temp_node = queue.remove();

            /* Check if left child is present*/
            if(temp_node.left != null)
            {
                // If we have seen a non full node, and we see a node
                // with non-empty left child, then the given tree is not
                // a complete Binary Tree
                if(flag == true)
                    return false;

                // Enqueue Left Child
                queue.add(temp_node.left);
            }
            // If this a non-full node, set the flag as true
            else
                flag = true;

            /* Check if right child is present*/
            if(temp_node.right != null)
            {
                // If we have seen a non full node, and we see a node
                // with non-empty right child, then the given tree is not
                // a complete Binary Tree
                if(flag == true)
                    return false;

                // Enqueue Right Child
                queue.add(temp_node.right);

            }
            // If this a non-full node, set the flag as true
            else
                flag = true;
        }
        // If we reach here, then the tree is complete Binary Tree
        return true;
    }


    public boolean isCompleteTree2(TreeNode root) {
        boolean end = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur == null) end = true;
            else{
                if(end) return false;
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return true;
    }
}

