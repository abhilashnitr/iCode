package main.FAANG.TreeUtils;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumLevelSumofaBinaryTree {

    public int maxLevelSum(TreeNode root) {
        int maxValue = Integer.MIN_VALUE;
        int minLevel = 1;
        int currLevel = 0;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (q.size() > 0) {
            int size = q.size();
            currLevel++;
            int sumLevel = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sumLevel += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }

            if (maxValue < sumLevel) {
                minLevel = currLevel;
                maxValue = sumLevel;
            }
        }

        return minLevel;
    }
}
