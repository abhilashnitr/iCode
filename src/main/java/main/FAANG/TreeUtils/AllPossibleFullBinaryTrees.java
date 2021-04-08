package main.FAANG.TreeUtils;

import java.util.ArrayList;
import java.util.List;

//A full binary tree is a binary tree where each node has exactly 0 or 2 children.
//Input: n = 7
//Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0]
// ,[0,0,0,0,0,null,null,0,0]]
public class AllPossibleFullBinaryTrees {

    public static void main(String[] args) {
        AllPossibleFullBinaryTrees allPossibleFullBinaryTrees=new AllPossibleFullBinaryTrees();
        System.out.println(allPossibleFullBinaryTrees.allPossibleFBT(7));
    }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> list = new ArrayList<>();
        if (N % 2 == 0) return list;
        if (N == 1) {
            list.add(new TreeNode(0));
            return list;
        }
        for (int leftNum = 1; leftNum <= N-1; leftNum += 2) {
            List<TreeNode> fLeft = allPossibleFBT(leftNum);
            List<TreeNode> fRight = allPossibleFBT(N-leftNum-1);
            for (TreeNode left: fLeft) {
                for (TreeNode right: fRight) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }

        return list;
    }
}
