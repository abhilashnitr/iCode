package main.FAANG.DPUtils.P1;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s="BABABCBADCEDE";
        LongestPalindromicSubsequence longestPalindromicSubsequence=new LongestPalindromicSubsequence();
        System.out.println(s.length()-longestPalindromicSubsequence.longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {

        int n=s.length();
        int dp[][]=new int[n][n];

        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }

        for(int l=2;l<=n;l++){
            for(int i=0;i<n-l+1;i++){
                int j=i+l-1;
                if(s.charAt(i)==s.charAt(j)){
                    if(l==2)
                        dp[i][j]=2;
                    else{
                        dp[i][j]=dp[i+1][j-1]+2;
                    }
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];

    }
}
