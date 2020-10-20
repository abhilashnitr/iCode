package main.StringUtils;


public class MinCostToMakeStringIdentical  {

  public static void main(String[] args) {
    String X = "ef";
    String Y = "gh";
    System.out.println( "Minimum Cost to make two strings "
        + " identical is = "
        + findMinCost(X, Y, 10, 20));
  }
  static int findMinCost(String X, String Y, int costX, int costY)
  {

    int m = X.length();
    int n = Y.length();
    int len_LCS;
    len_LCS = lcs(X.toCharArray(), Y.toCharArray(), m, n);


    return costX * (m - len_LCS) +
        costY * (n - len_LCS);
  }

  public static int lcs( char[] X, char[] Y, int m, int n )
  {
    if (m == 0 || n == 0)
      return 0;
    if (X[m-1] == Y[n-1])
      return 1 + lcs(X, Y, m-1, n-1);
    else
      return Math.max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
  }
}
