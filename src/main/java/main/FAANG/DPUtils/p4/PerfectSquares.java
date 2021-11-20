package main.FAANG.DPUtils.p4;

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {
        PerfectSquares perfectSquares=new PerfectSquares();
        System.out.println(perfectSquares.numSquares2(12));
    }

    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int j=1;
            while(i-j*j>=0){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                j++;
            }
        }
        return dp[n];
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n];
    }
}
