package main.FAANG.DPUtils.Stock;

public class STOCKSMaxProfit {

    public static void main(String[] args) {
        int[] price={1,3,2,8,4,9};
        int fee=2;

        STOCKSMaxProfit stocksMaxProfit=new STOCKSMaxProfit();
        int x=stocksMaxProfit.maxProfit(price,fee);
        System.out.println(x);

    }

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
