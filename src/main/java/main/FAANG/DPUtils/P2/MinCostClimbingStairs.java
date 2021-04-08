package main.FAANG.DPUtils.P2;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
       int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {

        int n=cost.length;
        int dp[]= new int[n];

        for(int i=0;i<n;i++){
            if(i<2) {
                dp[i] = cost[i];
                continue;
            }
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        return Math.min(dp[n-1],dp[n-2]);
    }
}
