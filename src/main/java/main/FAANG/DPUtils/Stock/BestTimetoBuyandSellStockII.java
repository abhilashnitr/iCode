package main.FAANG.DPUtils.Stock;

public class BestTimetoBuyandSellStockII {

    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        BestTimetoBuyandSellStockII buyandSellStockII=new BestTimetoBuyandSellStockII();
        System.out.println(buyandSellStockII.maxProfit(arr));

    }

    //Many Transactions
    public int maxProfit(int[] prices) {
        int i = 0, buy, sell, profit = 0, N = prices.length - 1;
        while (i < N) {
            while (i < N && prices[i + 1] <= prices[i]) i++;
            buy = prices[i];

            while (i < N && prices[i + 1] > prices[i]) i++;
            sell = prices[i];

            profit += sell - buy;
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++)
            if(prices[i]>prices[i-1])
            profit +=  prices[i] - prices[i - 1];

        return profit;
    }
}
