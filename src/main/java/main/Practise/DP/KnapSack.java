package main.Practise.DP;

public class KnapSack {
  public static void main (String[] args) {
   int[] value={20, 5, 10, 40, 15, 25};
   int[] weight={1, 2,  3,  8,  7, 4};
   int W=3;

    System.out.println("Knapsack value is " +
        knapSack(value, weight, value.length , W));
    System.out.println("Knapsack value is " +
        knapSackDP(value, weight, value.length , W));
  }

  private static int knapSack (int[] value, int[] weight, int n, int W) {

    if(n==0||W==0)
      return 0;
    if(weight[n-1]>W)
      return knapSack(value,weight,n-1,W);
    else
      return Math.max(knapSack(value,weight,n-1,W),knapSack(value,weight,n-1,W-weight[n-1])+value[n-1]);
  }
  private static int knapSackDP (int[] value, int[] weight, int n, int W) {

    int[][] dp=new int[n+1][W+1];
    for(int i=0;i<= n;i++){
      for(int j=0;j<=W;j++) {
        if(i==0||j==0)
          dp[i][j]=0;
        else if (weight[i-1] <= j) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i-1]] + value[i - 1]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    return dp[n][W];
  }
  }
