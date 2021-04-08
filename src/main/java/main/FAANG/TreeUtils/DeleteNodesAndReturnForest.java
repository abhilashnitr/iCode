package main.FAANG.TreeUtils;

import java.util.*;

public class DeleteNodesAndReturnForest {
//Given the root of a binary tree, each node in the tree has a distinct value.
//
//After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
//
//Return the roots of the trees in the remaining forest. You may return the result in any order.

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if (root == null) return new ArrayList<>();

        Set<TreeNode> resSet = new HashSet<>();
        resSet.add(root);
        if (to_delete.length == 0) return new ArrayList<>(resSet);

        Set<Integer> toDelete = new HashSet<>();
        for (int val : to_delete) toDelete.add(val);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (toDelete.contains(node.val)) {
                resSet.remove(node);
                if (node.left != null) resSet.add(node.left);
                if (node.right != null) resSet.add(node.right);
            }
            if (node.left != null) {
                q.offer(node.left);
                if (toDelete.contains(node.left.val)) node.left = null;
            }
            if (node.right != null) {
                q.offer(node.right);
                if (toDelete.contains(node.right.val)) node.right = null;
            }
        }
        return new ArrayList<>(resSet);
    }

    public List<TreeNode> delNodes2(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) set.add(i);
        List<TreeNode> res = new ArrayList<>();
        if (!set.contains(root.val)) res.add(root);
        dfs(root, set, res);
        return res;
    }

    private TreeNode dfs(TreeNode node, Set<Integer> set, List<TreeNode> res) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left, set, res);
        node.right = dfs(node.right, set, res);
        if (set.contains(node.val)) {
            if (node.left != null) res.add(node.left);
            if (node.right != null) res.add(node.right);
            return null;
        }
        return node;
    }

}
