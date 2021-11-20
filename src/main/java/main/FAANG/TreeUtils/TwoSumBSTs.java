package main.FAANG.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

//1214. Two Sum BSTs (https://leetcode.com/problems/two-sum-bsts/): Given two binary search trees, return True if and
// only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.
public class TwoSumBSTs {

    // Tree + Recursion solution
// Time: O(2 ^ (h1 + h2)), 976ms
// Space: O(h1 + h2), 38.7mb
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            // Base cases
            if(root1 == null || root2 == null) return false;
            if(root1.val + root2.val == target) return true;

            if(root1.val + root2.val < target) {
                // Go right in either tree if sum is smaller
                return twoSumBSTs(root1.right, root2, target) || twoSumBSTs(root1, root2.right, target);

            } else { // root1.val + root2.val > target
                // Go left in either tree if sum is larger
                return twoSumBSTs(root1.left, root2, target) || twoSumBSTs(root1, root2.left, target);
            }
        }


    // Tree + DFS (iterative) solution
// Time: O(n1 + n2), 2ms
// Space: O(h1 + h2), 38.2mb
        Deque<TreeNode> s1 = new ArrayDeque<>();
        Deque<TreeNode> s2 = new ArrayDeque<>();
        TreeNode n1;
        TreeNode n2;

        public boolean twoSumBSTs2(TreeNode root1, TreeNode root2, int target) {
            // Init the getNext() and getPrev()
            n1 = root1;
            n2 = root2;

            // Start searching from the min of first tree and the max of second tree
            TreeNode node1 = getNext();
            TreeNode node2 = getPrev();

            while(node1 != null && node2 != null) {
                if(node1.val + node2.val == target) return true;

                if(node1.val + node2.val < target) {
                    // node1 is too small for any nodes in root2
                    node1 = getNext();

                } else {
                    // node2 is too large for any nodes in root1
                    node2 = getPrev();
                }
            }

            return false;
        }

        // In order traversal (LPR) of the tree root1 and return next
        private TreeNode getNext() {
            if(!hasNext()) return null;

            while(n1 != null) {
                s1.push(n1);
                n1 = n1.left;
            }

            TreeNode ans = s1.pop();
            n1 = ans.right;
            return ans;
        }

        // Reversed in order traversal (RPL) of the tree root2 and return next
        private TreeNode getPrev() {
            if(!hasPrev()) return null;

            while(n2 != null) {
                s2.push(n2);
                n2 = n2.right;
            }

            TreeNode ans = s2.pop();
            n2 = ans.left;
            return ans;
        }

        private boolean hasNext() {
            return !s1.isEmpty() || n1 != null;
        }

        private boolean hasPrev() {
            return !s2.isEmpty() || n2 != null;
        }

}
