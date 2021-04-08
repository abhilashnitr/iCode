package main.FAANG.DPUtils.P1;

public class LongestCommonSubsequence {


    public static void main(String[] args) {
        String s="abcdef";
        String t="acdg";
        LongestCommonSubsequence longestCommonSubsequence =new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence(s,t));
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

        int i=n1;
        int j=n2;
        char[] lcs=new char[dp[n1][n2]];
        int index=dp[n1][n2]-1;
        while (i>0&j>0){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                lcs[index]=text1.charAt(i-1);
                index--;
                i--;
                j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }else
                j--;

        }
        for(char c:lcs)
            System.out.print(c);
        System.out.println();
        return dp[n1][n2];
    }
}
