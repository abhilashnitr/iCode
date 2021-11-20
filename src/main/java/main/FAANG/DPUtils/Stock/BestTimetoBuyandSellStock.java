package main.FAANG.DPUtils.Stock;

public class BestTimetoBuyandSellStock {

    // single day
    public int maxProfitI(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public int maxProfit(int[] prices){
        int min=prices[0];
        int max_profit=0;
        for(int i=0;i<prices.length;i++){
            min=Math.min(min,prices[i]);
            max_profit=Math.max(max_profit,prices[i]-min);
        }

        return max_profit;

    }

}
