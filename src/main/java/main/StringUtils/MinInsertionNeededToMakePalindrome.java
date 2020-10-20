package main.StringUtils;

public class MinInsertionNeededToMakePalindrome {

  static boolean ispalindrome(String s) {
    int l = s.length();

    for (int i = 0, j = l - 1; i <= j; i++, j--) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "BABABAA";
    int cnt = 0;
    int flag = 0;

    while (s.length() > 0) {
      if (ispalindrome(s)) {
        flag = 1;
        break;
      } else {
        cnt++;

        s = s.substring(0, s.length() - 1);
      }
    }

    if (flag == 1) {
      System.out.println(cnt);
    }
  }


  //Method 2
  /*
  O(n) time O(n) space
  */

  static int getMinCharToAddedToMakeStringPalin(String str)
  {
    StringBuilder s = new StringBuilder();
    s.append(str);

    // Get concatenation of string, special character
    // and reverse string
    String rev = s.reverse().toString();
    s.reverse().append("$").append(rev);

    // Get LPS array of this concatenated string
    int lps[] = computeLPSArray(s.toString());
    return str.length() - lps[s.length() - 1];
  }

  public static int[] computeLPSArray(String str)
  {
    int n = str.length();
    int lps[] = new int[n];
    int i = 1, len = 0;
    lps[0] = 0; // lps[0] is always 0

    while (i < n)
    {
      if (str.charAt(i) == str.charAt(len))
      {
        len++;
        lps[i] = len;
        i++;
      }
      else
      {
        // This is tricky. Consider the example.
        // AAACAAAA and i = 7. The idea is similar
        // to search step.
        if (len != 0)
        {
          len = lps[len - 1];

          // Also, note that we do not increment
          // i here
        }
        else
        {
          lps[i] = 0;
          i++;
        }
      }
    }
    return lps;
  }


  //Method 3 Recursion
  static int findMinInsertions(char str[], int l,
      int h)
  {
    // Base Cases
    if (l > h) return Integer.MAX_VALUE;
    if (l == h) return 0;
    if (l == h - 1) return (str[l] == str[h])? 0 : 1;

    // Check if the first and last characters
    // are same. On the basis of the  comparison
    // result, decide which subrpoblem(s) to call
    return (str[l] == str[h])?
        findMinInsertions(str, l + 1, h - 1):
        (Integer.min(findMinInsertions(str, l, h - 1),
            findMinInsertions(str, l + 1, h)) + 1);
  }
  //DP Solution
  // Time complexity: O(N^2)
  // Auxiliary Space: O(N^2)
  static int findMinInsertionsDP(char str[], int n)
  {
    int table[][] = new int[n][n];
    int l, h, gap;
    for (gap = 1; gap < n; ++gap)
      for (l = 0, h = gap; h < n; ++l, ++h)
        table[l][h] = (str[l] == str[h])?
            table[l+1][h-1] :
            (Integer.min(table[l][h-1],
                table[l+1][h]) + 1);

    return table[0][n-1];
  }

  //LPS Solution
  //Find the length of LCS of input string and its reverse. Let the length be ‘l’.
  //The minimum number insertions needed is length of input string minus ‘l’.
 // Time complexity: O(N^2)
 // Auxiliary Space: O(N^2)

  static int lcs( String X, String Y, int m, int n )
  {
    int L[][] = new int[n+1][n+1];
    int i, j;

        /* Following steps build L[m+1][n+1] in
           bottom up fashion. Note that L[i][j]
           contains length of LCS of X[0..i-1]
           and Y[0..j-1] */
    for (i=0; i<=m; i++)
    {
      for (j=0; j<=n; j++)
      {
        if (i == 0 || j == 0)
          L[i][j] = 0;

        else if (X.charAt(i-1) == Y.charAt(j-1))
          L[i][j] = L[i-1][j-1] + 1;

        else
          L[i][j] = Integer.max(L[i-1][j], L[i][j-1]);
      }
    }

        /* L[m][n] contains length of LCS for
           X[0..n-1] and Y[0..m-1] */
    return L[m][n];
  }

  static int findMinInsertionsLCS(String str, int n)
  {
    // Using StringBuffer to reverse a String
    StringBuffer sb = new StringBuffer(str);
    sb.reverse();
    String revString = sb.toString();

    // The output is length of string minus
    // length of lcs of str and it reverse
    return (n - lcs(str, revString , n, n));
  }

}
