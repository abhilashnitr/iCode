package main.Practise.DP;

public class EditDistance {

  public static void main (String[] args) {
    String X = "kitten", Y = "sitting";

    System.out.println("The Levenshtein Distance is " +
        editDist(X, X.length(), Y, Y.length()));

    System.out.println("The Levenshtein Distance is " +
        editDistDP(X, X.length(), Y, Y.length()));
  }

  private static int editDist (String x, int m, String y, int n) {
    if(m==0)
      return n;
    if(n==0)
      return m;
    if(x.charAt(m-1)==y.charAt(n-1))
      return editDist(x,m-1,y,n-1);
    return Math.min(editDist(x, m - 1, y, n) + 1,Math.min(  // deletion (case 3a))
        editDist(x, m, y, n - 1) + 1,         // insertion (case 3b))
        editDist(x, m - 1, y, n - 1) + 1)); // substitution (case 2 & 3c)
  }

  private static int editDistDP (String x, int m, String y, int n) {
    int[][] T = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++)
      T[i][0] = i;				// (case 1)
    for (int j = 1; j <= n; j++)
      T[0][j] = j;				// (case 1)

    int cost;
    for (int i = 1; i <= m; i++)
    {
      for (int j = 1; j <= n; j++)
      {
        if (x.charAt(i-1) == y.charAt(j-1))	 // (case 2)
          cost = 0;   						// (case 2)
        else
          cost = 1;   						// (case 3c)

        T[i][j] = Math.min(T[i - 1][j] + 1,  // deletion (case 3b)
            Math.max(T[i][j - 1] + 1,			// insertion (case 3a)
            T[i - 1][j - 1] + cost));	// replace (case 2 + 3c)
      }
    }
    return T[m][n];

  }

}
