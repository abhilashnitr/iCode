package main.FAANG.DPUtils.P1;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {
        String s="abc";
        String t="c";
        ShortestCommonSupersequence ssc =new ShortestCommonSupersequence();
        System.out.println(ssc.shortestCommonSupersequence(s,t));
    }

    public int shortestCommonSupersequence(String text1, String text2) {

        int n1=text1.length();
        int n2=text2.length();
        int dp[][]=new int[n1+1][n2+1];


        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if(i==0)
                    dp[i][j]=j;
                else if(j==0)
                    dp[i][j]=i;
                else if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=1+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        int l = dp[n1][n2]; // Length of the ShortestSuperSequence
        char[] arr = new char[l];
        int i=n1, j=n2;
        while(i>0 && j>0)
        {
            /* If current character in str1 and str2 are same, then
             current character is part of shortest supersequence */
            if(text1.charAt(i-1) == text2.charAt(j-1)) {
                arr[--l] = text1.charAt(i-1);
                i--;j--;
            }else if(dp[i-1][j]<dp[i][j-1]) {
                arr[--l] = text1.charAt(i-1);
                i--;
            }
            else {
                arr[--l] = text2.charAt(j-1);
                j--;
            }
        }
        while (i > 0) {
            arr[--l] = text1.charAt(i-1);
            i--;
        }
        while (j > 0) {
            arr[--l] = text2.charAt(j-1);
            j--;
        }

        System.out.println(new String(arr));
        return dp[n1][n2];
    }

}
