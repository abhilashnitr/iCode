package main.FAANG.DPUtils.P2.SubSetRelated;

public class CountSubsetsWithGivenSum {

    public static void main(String[] args) {
        int[] arr={1,2,3,3,5};
        //1 2 3 ,  1 2 3 , 3 3 , 1 5
        CountSubsetsWithGivenSum countSubsetsWithGivenSum=new CountSubsetsWithGivenSum();
        System.out.println(countSubsetsWithGivenSum.countGivenSumSubSet(arr,6));
    }

    public int countGivenSumSubSet(int[] nums,int sum){
        int n = nums.length;
        int[][] dp = new int[n+1][sum+1];


        dp[0][0] = 1;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] +=  dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
