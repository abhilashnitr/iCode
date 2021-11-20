package main.FAANG.DPUtils.Stock;

//After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75931/Easiest-JAVA-solution-with-explanations
//buy[i]: Max profit till index i. The series of transaction is ending with a buy.
//sell[i]: Max profit till index i. The series of transaction is ending with a sell.
//buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
//sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
//DP solution only depending on i - 1 and i - 2 can be optimized using O(1) space.
//
//Let b2, b1, b0 represent buy[i - 2], buy[i - 1], buy[i]
//Let s2, s1, s0 represent sell[i - 2], sell[i - 1], sell[i]
//Then arrays turn into Fibonacci like recursion:
//
//b0 = Math.max(b1, s2 - prices[i]);
//s0 = Math.max(s1, b1 + prices[i]);
public class BestTimetoBuyandSellStockwithCooldown {

    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;

        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;

        for(int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);
            s0 = Math.max(s1, b1 + prices[i]);
            b1 = b0; s2 = s1; s1 = s0;
        }
        return s0;
    }
}
