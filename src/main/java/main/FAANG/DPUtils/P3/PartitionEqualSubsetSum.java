package main.FAANG.DPUtils.P3;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] arr= {1,5,10,22};
        int sum=0;
        for(int s:arr)
            sum+=s;

        System.out.println(sumSetSum(arr,sum/2,arr.length-1));
    }
    public static boolean  sumSetSum(int[] arr,int target,int index){
        if(target==0)
            return true;
        else if(index==0||target<0)
            return false;

        //exclude and include condition.
        return sumSetSum(arr,target,index-1)||sumSetSum(arr,target-arr[index],index-1);

    }

    public static boolean  sumSetSumWithMemo(int[] arr,int target,int index,int[][] memo){
        if(target==0)
            return true;
        else if(index==0||target<0)
            return false;


        if(memo[index][target] == 0){
            //exclude and include condition.
            boolean result = sumSetSum(arr, target, index - 1) || sumSetSum(arr, target - arr[index], index - 1);
            memo[index][target] = result ? 1 : -1;
        }

        return memo[index][target]==1;
    }


    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], false);
        }

        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        return dp[n][sum];
    }



    public boolean canPartition2(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i-num];
                }
            }
        }

        return dp[sum];
    }
}
