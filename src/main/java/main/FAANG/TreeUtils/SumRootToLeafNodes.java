package main.FAANG.TreeUtils;

public class SumRootToLeafNodes {

    public int sumNumbers(TreeNode root) {

        return sum(root,0);
    }

    public int sum(TreeNode curr,int currSum){
        if(curr==null)
            return 0;
        int sum=currSum*10+curr.val;

        if(curr.left==null && curr.right==null)
            return sum;

        int leftSum = sum(curr.left,sum);
        int rightSum = sum(curr.right,sum);

        return leftSum + rightSum;

    }
}
