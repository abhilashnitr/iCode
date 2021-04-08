package main.DP_utils;

//Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty
// continuous subarrays.
//
//Write an algorithm to minimize the largest sum among these m subarrays.
public class SplitArrayLargestSum {
    public static int splitArray(int[] nums, int m) {

        int n=nums.length;
        int[][] dp=new int[n+1][m+1];
        int[] sum=new int[n+1];

        for(int i=0;i<=n;i++)
            for(int j=0;j<=m;j++){
             dp[i][j]=Integer.MAX_VALUE;
            }

        for(int i=0;i<n;i++)
            sum[i+1]=sum[i]+nums[i];

        dp[0][0]=0;
        for(int i =1;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int k=0;k<i;k++){
                    dp[i][j]=Math.min(dp[i][j],Math.max(dp[k][j-1],sum[i]-sum[k]));
                }
            }
        }

        return dp[n][m];
    }
}
