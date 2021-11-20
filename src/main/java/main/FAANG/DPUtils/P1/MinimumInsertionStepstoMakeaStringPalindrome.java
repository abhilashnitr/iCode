package main.FAANG.DPUtils.P1;

import main.FAANG.ArrayUtils.PascalTriangle;

public class MinimumInsertionStepstoMakeaStringPalindrome {


    public static void main(String[] args) {
        String X = "bad";
        int n = X.length();
        MinimumInsertionStepstoMakeaStringPalindrome min=new MinimumInsertionStepstoMakeaStringPalindrome();
        System.out.println(min.minInsertions(X));
    }

    public int minInsertions(String s) {
        if(s.length()==0)
            return s.length();
        StringBuilder revStr = new StringBuilder();
        revStr.append(s);
        revStr=revStr.reverse();
        String revS=String.valueOf(revStr);
        int x=longestCommonSubsequence(s,revS);
        return s.length()-x;
    }

    public int longestCommonSubsequence(String text1, String text2) {

        int n1=text1.length();
        int n2=text2.length();
        int dp[][]=new int[n1+1][n2+1];


        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n1][n2];
    }

    public int minInsertions2(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                dp[i + 1][j + 1] = s.charAt(i) == s.charAt(n - 1 - j) ? dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
        return n - dp[n][n];
    }

    public int minInsertions3(String X) {
        int st=0;
        int end=X.length()-1;
        int[][] Dp=new int[end+1][end+1];
        for(int k=0;k<=end;k++){
            Dp[k][k]=0;
        }
        int i, j, cl;
        for (cl = 2; cl <= end+1; cl++) {
            for (i = 0; i <= end - cl + 1; i++) {
                j = i + cl - 1;
                if (X.charAt(i) == X.charAt(j) && cl == 2)
                    Dp[i][j] = 0;
                else if (X.charAt(i) == X.charAt(j))
                    Dp[i][j] = Dp[i + 1][j - 1];
                else
                    Dp[i][j] =Math.min(Dp[i+1][j],Dp[i][j-1])+1;

            }
        }

        return Dp[st][end];
    }
}
