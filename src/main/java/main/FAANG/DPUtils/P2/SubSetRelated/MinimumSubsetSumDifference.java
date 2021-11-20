package main.FAANG.DPUtils.P2.SubSetRelated;

public class MinimumSubsetSumDifference {

    public static int canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return -1;
        }
        sum /= 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n+1][sum+1];


        dp[0][0] = true;

        for (int i = 1; i < n+1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= nums[i-1]) {
                    dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
                }
            }
        }

        int diff = Integer.MAX_VALUE;
        for(int i=0;i<=sum;++i)
        {
            int first = i;
            int second = sum-i;
            if(dp[n][i] && diff>Math.abs(first-second))
                diff = Math.abs(first-second);
        }

        return diff;
    }
}
