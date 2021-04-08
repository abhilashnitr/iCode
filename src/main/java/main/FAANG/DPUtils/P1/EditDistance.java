package main.FAANG.DPUtils.P1;

public class EditDistance {


    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int dp[][]=new int[n1+1][n2+1];

        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if(i==0&&j==0){
                    dp[i][j]=0;
                }
                else if(i==0){
                    dp[0][j]=j;
                }else if(j==0){
                    dp[i][0]=i;
                }
                else{
                    if(word1.charAt(i-1)==word2.charAt(j-1))
                        dp[i][j]=dp[i-1][j-1];
                    else
                        dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[n1][n2];
    }

    /*
    Let following be the function definition :-
    f(i, j) := minimum cost (or steps) required to convert first i characters of word1 to first j characters of word2

    Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
    f(i, j) = f(i - 1, j - 1)

    Case 2: word1[i] != word2[j], then we must either insert, delete or replace, whichever is cheaper
    f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }

        f(i, j - 1) represents insert operation
        f(i - 1, j) represents delete operation
        f(i - 1, j - 1) represents replace operation
*/
}
