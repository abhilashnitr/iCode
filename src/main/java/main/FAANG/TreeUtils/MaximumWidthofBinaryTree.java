package main.FAANG.TreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaximumWidthofBinaryTree {

    //We know that a binary tree can be represented by an array (assume the root begins from the position with index 1
    // in the array). If the index of a node is i, the indices of its two children are 2*i and 2*i + 1. The idea is to
    // use two arrays (start[] and end[]) to record the the indices of the leftmost node and rightmost node in each level
    // , respectively. For each level of the tree, the width is end[level] - start[level] + 1. Then, we just need to find
    // the maximum width.

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }

    //Use normal bfs traversal level by level style only important point is we will also add the null nodes in the deque
    // and after processing level will remove all the null nodes before first and last non null nodes of the level.
    //And in processing we caught null node we will add both left and right child as null in deque.

    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> deque = new LinkedList<>(); // initialize deque
        deque.add(root); // add root node in deque
        int maxWidth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size(); // size of current level
            maxWidth = Math.max(maxWidth, size);
            while (size-- > 0) {
                TreeNode node = deque.poll();
                if (node == null) { // node was null then to maintain add both left and right as null
                    deque.add(null);
                    deque.add(null);
                } else {
                    deque.add(node.left);
                    deque.add(node.right);
                }
            }
            while (!deque.isEmpty() && deque.peekFirst() == null)
                deque.pollFirst(); // remove all the null from the start until encounter first last non null node of level
            while (!deque.isEmpty() && deque.peekLast() == null)
                deque.pollLast(); // remove all the null from the last until encounter last non null node of level
        }
        return maxWidth;
    }
}
