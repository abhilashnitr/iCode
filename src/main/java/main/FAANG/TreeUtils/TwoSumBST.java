package main.FAANG.TreeUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class TwoSumBST {

//This method also works for those who are not BSTs. The idea is to use a hashtable to save the values of the nodes in the BST. Each time when we insert the value of a new node into the hashtable, we check if the hashtable contains k - node.val.
//
//Time Complexity: O(n), Space Complexity: O(n).
    public boolean findTarget1(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }
//The idea is to use a sorted array to save the values of the nodes in the BST by using an inorder traversal. Then, we use two pointers which begins from the start and end of the array to find if there is a sum k.
//
//Time Complexity: O(n), Space Complexity: O(n).

    public boolean findTarget2(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for(int i = 0, j = nums.size()-1; i<j;){
            if(nums.get(i) + nums.get(j) == k)return true;
            if(nums.get(i) + nums.get(j) < k)i++;
            else j--;
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> nums){
        if(root == null)return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

//Method 3.
//The idea is to use binary search method. For each node, we check if k - node.val exists in this BST.
//
//Time Complexity: O(nh), Space Complexity: O(h). h is the height of the tree, which is logn at best case, and n at worst case.
    public boolean findTarget3(TreeNode root, int k) {
        return dfs(root, root,  k);
    }

    public boolean dfs(TreeNode root,  TreeNode cur, int k){
        if(cur == null)return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    public boolean search(TreeNode root, TreeNode cur, int value){
        if(root == null)return false;
        return (root.val == value) && (root != cur)
                || (root.val < value) && search(root.right, cur, value)
                || (root.val > value) && search(root.left, cur, value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(17);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        TwoSumBST twoSumBST=new TwoSumBST();
        System.out.println(twoSumBST.findTarget3(root,9));

    }

    public boolean findTarget4(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        TreeNode start = root;
        TreeNode end = root;
        while (start.left != null) {
            start = start.left;
        }
        while (end.right != null) {
            end = end.right;
        }
        while (start != end) {
            int sum = start.val + end.val;
            if (sum > k) {
                end = findPredecessor(root, end);
            } else if (sum < k) {
                start = findSuccessor(root, start);
            } else {
                return true;
            }
        }
        return false;
    }
    private TreeNode findPredecessor(TreeNode root, TreeNode node) {
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < node.val) {
                pre = cur;
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return pre;
    }
    private TreeNode findSuccessor(TreeNode root, TreeNode node) {
        TreeNode succ = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val > node.val) {
                succ = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return succ;
    }

    public boolean findTarget5(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> leftStack = new Stack<TreeNode>();
        Stack<TreeNode> rightStack = new Stack<TreeNode>();
        initStack(leftStack, root, true);
        initStack(rightStack, root, false);
        while (leftStack.peek() != rightStack.peek()) {
            int sum = leftStack.peek().val + rightStack.peek().val;
            if (sum == k) {
                return true;
            } else if (sum > k) {
                findNext(rightStack, false);
            } else {
                findNext(leftStack, true);
            }
        }
        return false;
    }
    private void initStack(Stack<TreeNode> stack, TreeNode node, boolean isLeft) {
        TreeNode cur = node;
        while (cur != null) {
            stack.push(cur);
            cur = isLeft ? cur.left : cur.right;
        }
    }
    private void findNext(Stack<TreeNode> stack, boolean isLeft) {
        TreeNode cur = stack.pop();
        if (isLeft) {
            initStack(stack, cur.right, isLeft);
        } else {
            initStack(stack, cur.left, isLeft);
        }
    }





}
