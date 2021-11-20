package main.FAANG.DPUtils.P1;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {

        boolean dp[][]=new boolean[s.length()+1][p.length()+1];

        dp[0][0]=true;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*')
                dp[0][i+1]=dp[0][i-1];
        }

        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.')
                    dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                    if(s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.'){
                        dp[i][j]=dp[i][j-2]||dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i][j-2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    //1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
    //2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
    //3, If p.charAt(j) == '*':
    //   here are two sub conditions:
    //               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
    //               2   if p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.':
    //                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
    //                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
    //                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
}
