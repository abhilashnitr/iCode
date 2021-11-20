package main.FAANG.DPUtils.P3;

public class PaintHouse {
    //dp[i][j] = cost[i][j]+min(cost[i-1][x]) for all x where x!=j.

    public int paintHouse(int[][] colors){

        int[][] dp=new int[colors.length][colors[0].length];

        for(int i=0;i<colors.length;i++)
            dp[0][i] = colors[0][i];

        for(int i=1;i<colors.length;i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + colors[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + colors[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + colors[i][2];
        }
        int n=colors.length-1;
        return Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2]));
    }
}
