package main.Practise.DP;

public class LCS {

  public static void main (String[] args) {
    String x = "ABCBDAB";
    String y = "BDCABA";
    System.out.println(getLCS(x, y, x.length(), y.length()));
    System.out.println(getLCSDP(x, y, x.length(), y.length()));
  }

  private static int getLCS (String x, String y, int m, int n) {
    if (m == 0 || n == 0)
      return 0;
    if (x.charAt(m - 1) == y.charAt(n - 1))
      return getLCS(x, y, m - 1, n - 1) + 1;
    else
      return Math.max(getLCS(x, y, m, n - 1), getLCS(x, y, m - 1, n));

  }

  private static int getLCSDP (String x, String y, int m, int n) {
    int[][] LCS = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      LCS[i][0] = 0;
    }
    for (int i = 0; i <= n; i++) {
      LCS[0][i] = 0;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          LCS[i][j] = LCS[i - 1][j - 1] + 1;
        } else {
          LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
        }
      }

    }

    return LCS[m][n];
  }

}
