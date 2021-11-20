package main.FAANG.TreeUtils;

import java.util.*;

public class BurnATree2 {

    public static int res;

    public static void inorder(TreeNode root, HashMap<Integer, ArrayList<Integer>> m)
    {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;
        // Traverse the tree
        while (curr != null || s.size() > 0)
        {
            // Push all the nodes left to 'cur' in stack.
            while (curr != null)
            {
                s.push(curr);
                // Insert key if not present
                if (m.get(curr.val) == null)
                {
                    m.put(curr.val, new ArrayList<>());
                }
                // If left child is present
                if (curr.left != null)
                {
                    // Add an edge
                    m.get(curr.val).add(curr.left.val);
                    // Insert key if not present.
                    if (m.get(curr.left.val) == null)
                    {
                        m.put(curr.left.val, new ArrayList<>());
                    }
                    m.get(curr.left.val).add(curr.val);
                }
                curr = curr.left;
            }
            // Pop the top node from stack.
            curr = s.pop();
            // If right child is present
            if (curr.right != null)
            {
                // Add an edge.
                m.get(curr.val).add(curr.right.val);
                m.computeIfAbsent(curr.right.val, k -> new ArrayList<>());
                m.get(curr.right.val).add(curr.val);
            }
            curr = curr.right;
        }
    }

    public static int timeToBurnTree(TreeNode root, int start)
    {
        // Initialize map to store edges and vertices.
        HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
        // Store edges by doing inorder traversal.
        inorder(root, m);
        // Initialize queue for bfs traversal.
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        // Variable to keep count of number of levels from start node.
        int count = 0;
        HashMap<Integer, Boolean> visited = new HashMap<>();
        visited.put(start, true);
        // Iterate while queue is not empty.
        while (!q.isEmpty())
        {
            count++;
            int n = q.size();
            for (int i = 0; i < n; i++)
            {
                int node = q.peek();
                q.poll();
                for (int num : m.get(node))
                {
                    if (visited.get(num) == null)
                    {
                        q.add(num);
                        visited.put(num, true);
                    }
                }
            }
        }
        return count - 1;
    }
    //O(N), where ‘N’ is the number of nodes in the tree.
    //In the undirected graph, there will be ‘N’ vertices and 2(N-1) edges. So the overall space complexity is O(N + 2(N-1) = O(N)

    static class Data {
        int leftDepth, rightDepth, time;
        boolean contains;

        Data()
        {
            contains = false;
            leftDepth = rightDepth = 0;
            time = -1;
        }
    }
    /*
        ***********ADDITIONAL INFO*************
        lDepth - maximum height of left subtree
        rDepth - maximum height of right subtree
        contains - stores true if tree rooted at current node
                contains the first burnt node
        time - time to reach fire from the initially burnt leaf
            node to this node
    */
    public static void getResult(TreeNode node, Data data, int target)
    {
        // Base case: if root is null
        if (node == null) {
            return;
        }
        // If current node is leaf
        if (node.left == null && node.right == null) {
            // If current node is the first burnt node
            if (node.val == target) {
                data.contains = true;
                data.time = 0;
            }
            return;
        }
        // Information about left child
        Data leftData = new Data();
        getResult(node.left, leftData, target);
        // Information about right child
        Data rightData = new Data();
        getResult(node.right, rightData, target);
        // If left subtree contains the fired node then
        // time required to reach fire to current node
        // will be (1 + time required for left child)
        data.time = (leftData.contains) ? (leftData.time + 1) : -1;
        // If right subtree contains the fired node then
        // time required to reach fire to current node
        // will be (1 + time required for right child)
        if (data.time == -1)
            data.time = (rightData.contains) ? (rightData.time + 1) : -1;
        // Storing(true or false) if the tree rooted at
        // current node contains the fired node
        data.contains = (leftData.contains || rightData.contains);
        // Calculate the maximum depth of left subtree
        data.leftDepth = (node.left == null) ? 0 : (1 + Math.max(leftData.leftDepth, leftData.rightDepth));
        // Calculate the maximum depth of right subtree
        data.rightDepth = (node.right == null) ? 0 : (1 + Math.max(rightData.leftDepth, rightData.rightDepth));
        // Calculating answer
        if (data.contains) {
            // If left subtree exists and
            // it contains the fired node
            if (leftData.contains) {
                // calculate result
                res = Math.max(res, data.time + data.rightDepth);
            }
            // If right subtree exists and it
            // contains the fired node
            if (rightData.contains) {
                // calculate result
                res = Math.max(res, data.time + data.leftDepth);
            }
        }
    }


    static int result = -1;
    public static int burnTree(TreeNode A,int B,Dis dis)
    {
        if(A == null)
            return 0;
        if(B == A.val)
        {
            dis.dis = 0;
            return 1;
        }
        Dis ldis = new Dis(-1),rdis = new Dis(-1);
        int lh = burnTree(A.left,B,ldis);
        int rh = burnTree(A.right,B,rdis);
        if(ldis.dis != -1){
            dis.dis = ldis.dis +1;
            result = Math.max( result,dis.dis+rh);
        }
        else if(rdis.dis != -1){
            dis.dis = rdis.dis +1;
            result = Math.max( result,dis.dis+lh);
        }
        return (lh>rh)?lh+1:rh+1;
    }



   // https://helloml.org/burning-tree-problem/
    //Write a function burnTime( ) same as finding the height. Every call stack returns the height of the tree from that
   // node to the leaf. Also, we maintain a variable dist as a reference in every call stack that will store the distance
   // of that particular node from the target node( here 50 ).
   //
   //The base case for burnTime( ) is same as that of height i.e if the root==NULL return 0.
   //Check if the root data is equal to the given target. Then find the height of the target from its subtree leaf. If
   // the target is a leaf node, then it’s quite simple to return the height as 1. If it’s not a leaf node, then find the
   // height using the height( ) function written, and also initialize the reference variable dist as 0. As the distance
   // from the target node to the current node is 0.
   //Now recurring the above step to the left and right subtree.
   //If the ldist value, i.e distance of a left node to the target node is not equal to -1. Increase the distance of parent,
   // i.e current node by 1( as the distance from target to the current node is ldist+1 ). Now we have to find the height
   // of the right subtree, i.e already found and stored in rh variable. As the max path can be from the target through
   // the current node to the max height, i.e calculated as dist+rh.
   //If the rdist value, i.e distance of a right node to the target node is not equal to -1. Increase the distance of parent,
   // i.e current node by 1( as the distance from target to the current node is rdist+1 ). Now we have to find the height of
   // the left subtree, i.e already found and stored in lh variable. As the max path can be from the target through the current
   // node to the max height, i.e calculated as dist+lh.
   //Return 1+max(lh+rh) to return the height of this call stack.
    int height(Node  root)    // this function is only useful in case the given target node is not a leaf node.
    {
        if(root==null) return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
    int Result=0;  // global variable
    int burnTime(Node  root, int target,int dist)   // here dist is the distance of root->data node from leaf node, if it is a descendant.
    {
        if(root==null) return 0;
        if(root.data==target) // if root is the leaf
        {
            dist=0;
            int a=height(root.left);  // checking left height
            int b= height(root.right);// checking right height
            Result=Math.max(Result,Math.max(a,b));   // if any of these two are greater than result than initialize result to maximum.
            return 1+Math.max(a,b);  // return height ( this will be 1 for leaf node )
        }
        int ldist=-1,rdist=-1;
        int lh= burnTime(root.left,target,ldist);
        int rh= burnTime(root.right,target,rdist);
        if(ldist!=-1)   // if leaf is in left subtree than ldist>-1
        {
            dist=ldist+1;
            Result=Math.max(Result,dist+rh);   // maximum of result or current node distance from leaf + maximum height to the right side ( as leaf is on left subtree )
        }
        else if(rdist!=-1) // if leaf is in right subtree than rdist>-1
        {
            dist=rdist+1;
            Result=Math.max(Result,dist+lh);   // maximum of result or current node distance from leaf + maximum height to the lef side ( as leaf is on right subtree )
        }
        return (1+Math.max(lh,rh));    // this is return height that will be maximum height of either left or right subtree +1
    }


    public static int solve(TreeNode A, int B) {
        result = 0;
        burnTree(A,B,new Dis(-1));
        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(13);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(15);
        TreeNode left = root.right.left;
        TreeNode right = root.right.right;
        left.left = new TreeNode(21);
        left.right = new TreeNode(24);
        right.left = new TreeNode(22);
        right.right = new TreeNode(23);
//        System.out.println(timeToBurnTree(root,22));
//
//        res=0;
//        getResult(root, new Data(), 22);
//        System.out.println(res);

        System.out.println("3rd Solution " + solve(root,13));
    }
}

class Dis{
    int dis;
    Dis(int dis)
    {
        this.dis = dis;
    }
}
