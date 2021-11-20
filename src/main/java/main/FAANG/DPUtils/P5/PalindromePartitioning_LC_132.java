package main.FAANG.DPUtils.P5;

public class PalindromePartitioning_LC_132 {


    public static void main(String[] args) {
        PalindromePartitioning_LC_132 lc_132=new PalindromePartitioning_LC_132();
        System.out.println(lc_132.minPalPartion("aab",0,2));
    }
    boolean isPalindrome(String string, int i, int j)
    {
        while(i < j)
        {
            if(string.charAt(i) != string.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    int minPalPartion(String string, int i, int j)
    {
        if( i >= j || isPalindrome(string, i, j) )
            return 0;
        int ans = Integer.MAX_VALUE, count;
        for(int k = i; k < j; k++)
        {
            count = minPalPartion(string, i, k) +
                    minPalPartion(string, k + 1, j) + 1;

            ans = Math.min(ans, count);
        }
        return ans;
    }



    // public int minCut(String s) {
    //
    //    Boolean isPal[][]=new Boolean[s.length()][s.length()];
    //    Integer dp[][]=new Integer[s.length()][s.length()];
    //
    //        for (int i = 0; i < s.length(); i++) {
    //            isPal[i][i] = true;
    //            dp[i][i] = 0;
    //        }
    //
    //    return minPalPartion(s,0,s.length()-1,dp,isPal);
    //    }
    //
    //     public boolean isPalindrome(String string, int i, int j,Boolean[][] isPal)
    //    {
    //        if(isPal[i][j]!=null)
    //            return isPal[i][j];
    //        while(i < j)
    //        {
    //            if(string.charAt(i) != string.charAt(j))
    //                isPal[i][j]=false;
    //                return false;
    //            i++;
    //            j--;
    //        }
    //        isPal[i][j]=true;
    //        return true;
    //    }
    //
    //    public int minPalPartion(String string, int i, int j,Integer[][] dp,Boolean[][] isPal)
    //    {
    //        if( i >= j || isPalindrome(string, i, j,isPal) )
    //            return 0;
    //        if (dp[i][j] != null)
    //            return dp[i][j];
    //        int ans = Integer.MAX_VALUE, count;
    //        for(int k = i; k < j; k++)
    //        {
    //            count = minPalPartion(string, i, k,dp,isPal) +
    //                    minPalPartion(string, k + 1, j,dp,isPal) + 1;
    //
    //            ans = Math.min(ans, count);
    //        }
    //        dp[i][j]=ans;
    //        return ans;
    //    }
}
