package main.Practise.DP;

public class NoOfTImeSubsequenceOccursInString {

  public static void main(String[] args)
  {
    String X = "subsequence";   // input String
    String Y = "sue";		// pattern

    System.out.println(count(X, Y, X.length(), Y.length()));
    System.out.print(countDp(X, Y, X.length(), Y.length()));
  }

  private static int count (String X, String Y, int m, int n) {
    if (m == 1 && n == 1)
      return (X.charAt(0) == Y.charAt(0)) ? 1: 0;
    if (m == 0) {
      return 0;
    }
    if(n==0){
      return 1;
    }
    if (n > m) {
      return 0;
    }
    return ((X.charAt(m-1) == Y.charAt(n-1)) ?
        count(X, Y, m - 1, n - 1) : 0)
        + count(X, Y, m - 1, n);

  }
  public static int countDp(String X, String Y, int m, int n)
  {
    int[][] T = new int[m + 1][n + 1];
    // if pattern Y is empty, we have found subsequence
    for (int i = 0; i <= m; i++) {
      T[i][0] = 1;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++){
        T[i][j] = ((X.charAt(i-1) == Y.charAt(j-1)) ? T[i-1][j-1] : 0)
            + T[i-1][j];
      }
    }
    return T[m][n];
  }

}
