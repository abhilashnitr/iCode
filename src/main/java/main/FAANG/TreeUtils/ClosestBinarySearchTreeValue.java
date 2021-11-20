package main.FAANG.TreeUtils;

public class ClosestBinarySearchTreeValue {




    public int closestValue(TreeNode root, double target) {
        double min=Double.MAX_VALUE;
        int result = root.val;

        while(root!=null){
            if(target>root.val){

                double diff = Math.abs(root.val-target);
                if(diff<min){
                    min = Math.min(min, diff);
                    result = root.val;
                }
                root = root.right;
            }else if(target<root.val){

                double diff = Math.abs(root.val-target);
                if(diff<min){
                    min = Math.min(min, diff);
                    result = root.val;
                }
                root = root.left;
            }else{
                return root.val;
            }
        }

        return result;
    }


    int goal;
    double min = Double.MAX_VALUE;

    public int closestValueRec(TreeNode root, double target) {
        helper(root, target);
        return goal;
    }

    public void helper(TreeNode root, double target){
        if(root==null)
            return;

        if(Math.abs(root.val - target) < min){
            min = Math.abs(root.val-target);
            goal = root.val;
        }

        if(target < root.val){
            helper(root.left, target);
        }else{
            helper(root.right, target);
        }
    }
}
