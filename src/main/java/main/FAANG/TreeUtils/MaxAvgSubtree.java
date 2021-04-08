package main.FAANG.TreeUtils;

public class MaxAvgSubtree {
    double res=Integer.MIN_VALUE;
    public double findMaxAvg(Node root){
        dfs(root);
        return res;
    }

    private int[] dfs(Node root) {
        if(root==null)
            return new int[]{0,0};
        int[] l=dfs(root.left);
        int[] r=dfs(root.right);
        int sum=l[0]+r[0]+root.data;
        int count=l[1]+r[1]+1;
        res=Math.max(res,sum/count);
        return new int[]{sum,count};
    }

}
