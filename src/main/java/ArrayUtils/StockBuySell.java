package ArrayUtils;

public class StockBuySell {

  public static void main(String[] args) {
    int[] a={100, 180, 260, 310, 40, 535, 695};
    printMax(a);
  }

  private static void printMax(int[] prices) {
    int maxProfit = 0;
    int currentBuy = prices[0];
    int currentSell = prices[0];
    for(int i = 0; i < prices.length ; i++){
      if(prices[i] < currentBuy){
        currentBuy = prices[i];
        currentSell = prices[i + 1];
        if(currentSell - currentBuy > maxProfit){
          maxProfit = currentSell - currentBuy;
        }
      } else if(prices[i] > currentSell){
        currentSell = prices[i];
        if(currentSell - currentBuy > maxProfit){
          maxProfit = currentSell - currentBuy;
        }
      }
    }

    System.out.println(maxProfit);
  }

}
