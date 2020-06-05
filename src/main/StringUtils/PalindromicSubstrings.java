package main.StringUtils;

public class PalindromicSubstrings {

  public static void main(String[] args) {
    System.out.println(countSubstringsDp("aaa"));
  }

  public static int countSubstringsDp(String s) {
    int count = 0;
    if (s == null || s.length() == 0) {
      return count;
    }
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int i = 0; i < s.length(); i++) {
      dp[i][i] = true;
      count++;
    }
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) == s.charAt(i)) {
        dp[i - 1][i] = true;
        count++;
      }
    }
    for (int j = 2; j < s.length(); j++) {
      for (int i = 0; i < j; i++) {
        if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
          dp[i][j] = true;
          count++;
        }
      }
    }
    return count;
  }


  public static int countSubstrings(String s) {

    int count = 0;
    for(int ind = 0; ind < s.length(); ind++){

      count += countPal(ind, ind, s);//it will give the palindrome substrings of odd length
      count += countPal(ind, ind + 1, s);//it will give the palindrome substrings of even length
    }
    return count;
  }

  public static int countPal(int left, int right, String s){

    int count = 0;
    while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
      count++;
      left--;
      right++;
    }
    return count;
  }

}
