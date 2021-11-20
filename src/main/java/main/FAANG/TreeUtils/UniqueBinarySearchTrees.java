package main.FAANG.TreeUtils;

import java.util.LinkedList;
import java.util.List;

//Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
public class UniqueBinarySearchTrees {


    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }

    public int numTrees2(int n) {
        int [] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        for(int level = 2; level <=n; level++)
            for(int root = 1; root<=level; root++)
                dp[level] += dp[level-root]*dp[root-1];
        return dp[n];
    }


    //Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of
    // unique values from 1 to n. Return the answer in any order.'

    public List<Node> generateTrees(int n) {
        return generateSubtrees(1, n);
    }

    private List<Node> generateSubtrees(int s, int e) {
        List<Node> res = new LinkedList<Node>();
        if (s > e) {
            res.add(null); // empty tree
            return res;
        }

        for (int i = s; i <= e; ++i) {
            List<Node> leftSubtrees = generateSubtrees(s, i - 1);
            List<Node> rightSubtrees = generateSubtrees(i + 1, e);

            for (Node left : leftSubtrees) {
                for (Node right : rightSubtrees) {
                    Node root = new Node(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}



