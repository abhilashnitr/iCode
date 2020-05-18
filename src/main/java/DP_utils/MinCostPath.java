package DP_utils;

public class MinCostPath {

  public static void main(String[] args) {
    int cost[][] = { {1, 2, 3},
        {4, 8, 2},
        {1, 5, 3} };

    System.out.print(minCostDp(cost, 2, 2));
  }
  static int minCostDp(int cost[][],int m,int n){
    int i, j;
    int tc[][]=new int[m+1][n+1];

    tc[0][0] = cost[0][0];

    for(i=1;i<=m;i++){
      tc[i][0] = tc[i-1][0] + cost[i][0];
    }
    for (j = 1; j <= n; j++)
      tc[0][j] = tc[0][j-1] + cost[0][j];
    for (i = 1; i <= m; i++)
      for (j = 1; j <= n; j++)
        tc[i][j] = min(tc[i-1][j-1],
            tc[i-1][j],
            tc[i][j-1]) + cost[i][j];

    return tc[m][n];
  }
  static int minCost(int cost[][], int m,
      int n)
  {
    if (n < 0 || m < 0)
      return Integer.MAX_VALUE;
    else if (m == 0 && n == 0)
      return cost[m][n];
    else
      return cost[m][n] +
          min( minCost(cost, m-1, n-1),
              minCost(cost, m-1, n),
              minCost(cost, m, n-1) );
  }

  static int min(int x, int y, int z)
  {
    if (x < y)
      return (x < z) ? x : z;
    else
      return (y < z) ? y : z;
  }
}
