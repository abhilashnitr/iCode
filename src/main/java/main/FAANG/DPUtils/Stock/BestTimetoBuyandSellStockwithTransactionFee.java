package main.FAANG.DPUtils.Stock;
//buy[i] represents the max profit at day i in buy status, given that the last action you took is a buy action at day K, where K<=i. And you have the right to sell at day i+1, or do nothing.
//(2) sell status:
//sell[i] represents the max profit at day i in sell status, given that the last action you took is a sell action at day K, where K<=i. And you have the right to buy at day i+1, or do nothing.
//buy[0]=-prices[0];
//sell[0]=0;
//buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
//sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
public class BestTimetoBuyandSellStockwithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int days = prices.length, buy[] = new int[days], sell[] = new int[days];
        buy[0]=-prices[0];
        for (int i = 1; i<days; i++) {
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]); // keep the same as day i-1, or buy from sell status at day i-1
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee); // keep the same as day i-1, or sell from buy status at day i-1
        }
        return sell[days - 1];
    }

}
