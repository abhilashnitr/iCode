package main.Practise.DP;

public class MinDeletionToFormPallindrome {

  public static void main (String[] args) {
    String X = "BABABCBADCEDE";
    int n = X.length();

    System.out.println("The minimum number of deletions required are " +
        minDeletions(X, 0, n - 1));
    System.out.println("The minimum number of deletions required are " +
        minDeletionsDp(X, 0, n ));
  }

  private static int minDeletionsDp (String X, int st, int end) {
    int[][] Dp=new int[end+1][end+1];
    for(int k=0;k<=end;k++){
      Dp[k][k]=0;
    }
    int i, j, cl;
    for (cl = 2; cl <= end; cl++) {
      for (i = 0; i < end - cl + 1; i++) {
        j = i + cl - 1;
        if (X.charAt(i) == X.charAt(j) && cl == 2)
          Dp[i][j] = 0;
        else if (X.charAt(i) == X.charAt(j))
          Dp[i][j] = Dp[i + 1][j - 1];
        else
          Dp[i][j] =Math.min(Dp[i+1][j],Dp[i][j-1])+1;

      }
    }

    return Dp[st][end-1];
  }

  private static int minDeletions (String X, int i, int j) {
    if(i>=j)
      return 0;
    if (X.charAt(i) == X.charAt(j)) {
      return minDeletions(X, i + 1, j - 1);
    }
    return 1 + Math.min(minDeletions(X, i, j - 1), minDeletions(X, i + 1, j));
  }

}
