package main.FAANG.ArrayUtils;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1]+ cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }
    //Time Complexity: O(N) where N is the length of cost.
    //
    //Space Complexity: O(1), the space used by f1, f2.
}
