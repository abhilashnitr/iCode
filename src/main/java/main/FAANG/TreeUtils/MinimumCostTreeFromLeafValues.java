package main.FAANG.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumCostTreeFromLeafValues {
    List<Integer> result = new ArrayList();
    Stack<TreeNode> s1 = new Stack();
    Stack<TreeNode> s2 = new Stack();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        populate(root1, s1);
        populate(root2, s2);
        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode r1 = s1.peek();
            TreeNode r2 = s2.peek();
            if (r1.val > r2.val) {
                result.add(r2.val);
                s2.pop();
                populate(r2.right, s2);
            } else {
                result.add(r1.val);
                s1.pop();
                populate(r1.right, s1);
            }

        }
        Stack<TreeNode> s = s1.isEmpty() ? s2 : s1;
        while (!s.isEmpty()) {
            TreeNode r = s.pop();
            result.add(r.val);
            populate(r.right, s);
        }
        return result;
    }

    public void populate(TreeNode root, Stack<TreeNode> s) {
        if (root == null) {
            return;
        }
        s.add(root);
        populate(root.left, s);
    }
}
