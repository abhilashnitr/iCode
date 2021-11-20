package main.FAANG.DPUtils.Stock;

public class BestTimetoBuyandSellStockIII {

    public static void main(String[] args) {
        int[] prices={3,3,5,0,0,3,1,4};
        BestTimetoBuyandSellStockIII buyandSellStockIII=new BestTimetoBuyandSellStockIII();
        System.out.println(buyandSellStockIII.maxProfitDpCompactFinal(prices));
    }

    public int maxProfitDpCompactFinal(int[] prices)  {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int profit1 = 0, profit2 = 0;

        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            profit1 = Math.max(profit1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - profit1);
            profit2 = Math.max(profit2, prices[i] - buy2);
        }

        return profit2;
    }
}
