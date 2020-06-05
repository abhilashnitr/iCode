package main.Practise.DP;

public class ShortestSuperSequence {

  public static void main (String[] args) {
    String x = "ABCBDAB";
    String y = "BDCABA";
    System.out.println(getSSS(x, y, x.length(), y.length()));
    System.out.println(getSSSDP(x, y, x.length(), y.length()));
  }

  private static int getSSSDP (String x, String y, int m, int n) {
    int[][] SSS = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      SSS[i][0] = i;
    }
    for (int i = 0; i <= n; i++) {
      SSS[0][i] = i;
    }
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (x.charAt(i - 1) == y.charAt(j - 1)) {
          SSS[i][j] = SSS[i - 1][j - 1] + 1;
        } else {
          SSS[i][j] = Math.min(SSS[i - 1][j]+1, SSS[i][j - 1]+1);
        }
      }

    }
    return SSS[m][n];
  }

  private static int getSSS (String x, String y, int m, int n) {
    if (m == 0 || n == 0)
      return m+n;
    if (x.charAt(m - 1) == y.charAt(n - 1))
      return getSSS(x, y, m - 1, n - 1) + 1;
    else
      return Math.min(getSSS(x, y, m, n - 1)+1, getSSS(x, y, m - 1, n)+1);
  }

}
