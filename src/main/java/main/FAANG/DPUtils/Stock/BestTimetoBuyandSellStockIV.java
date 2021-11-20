package main.FAANG.DPUtils.Stock;


//k transaction
public class BestTimetoBuyandSellStockIV {
    public int maxProfit(int k ,int[] prices){
        if(k==0 || prices.length==0) return 0;
        //part2
        if(k>=prices.length){
            int profit = 0;
            for (int i = 1; i < prices.length; i++)
                if(prices[i]>prices[i-1])
                    profit +=  prices[i] - prices[i - 1];
            return profit;
        }

        //part1
        int min=prices[0];
        int p=0;
        int[][] dp=new int[k+1][prices.length];
        for(int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            p=Math.max(p,prices[i]-min);
            dp[1][i]=p;
        }

        //k transaction
       for(int i=2;i<=k;i++){
           int b2=Integer.MAX_VALUE;
           int p2=0;
           for(int j=0;j<prices.length;j++){
               b2=Math.min(b2,prices[j]-dp[i-1][j]);
               p2=Math.max(p2,prices[j]-b2);
               dp[i][j]=p2;
           }
       }

        return dp[k][prices.length-1];
    }


    //dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
}
