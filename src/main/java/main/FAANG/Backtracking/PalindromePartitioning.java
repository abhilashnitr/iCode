package main.FAANG.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {

        if(s==null || s.length()==0)
            return new ArrayList<>();

        List<List<String>> result=new ArrayList<>();
        helper(result,new ArrayList<>(), s);
        return result;
    }
    public void helper (List<List<String>> result,ArrayList<String> currentList,String temp)
    {
        if(temp==null || temp.length()==0){
            result.add(new ArrayList(currentList));
            return;
        }
        for(int i=1;i<=temp.length();i++){
            String leftString=temp.substring(0, i);
            if(!isPalindrome(leftString))
                continue;
            currentList.add(leftString);
            helper(result,currentList, temp.substring(i));
            currentList.remove(currentList.size()-1);
        }
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }

    Boolean isPal[][];
    Integer dp[][];
    public int minCut(String s) {

        dp = new Integer[s.length()][s.length()];
        isPal = new Boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPal[i][i] = true;
            dp[i][i] = 0;
        }

        return minPalPartion(s,0,s.length()-1);
    }
    private boolean isPalindrome(String s, int start, int end) {

        if (start >= end)
            return true;

        if (isPal[start][end] != null)
            return isPal[start][end];

        return isPal[start][end] = (s.charAt(start) == s.charAt(end))
                && isPalindrome(s, start + 1, end - 1);
    }
    public int minPalPartion(String string, int i, int j)
    {
        if( i >= j || isPalindrome(string, i, j) )
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int ans = string.length()-1, count;

        int leftCount,rightCount;

        for(int k = i; k < j; k++)
        {
            leftCount= isPalindrome(string, i, k)?0:minPalPartion(string, i, k) ;
            rightCount= isPalindrome(string, k+1, j)?0:minPalPartion(string, k+1, j) ;


            count = leftCount + rightCount + 1;
            ans = Math.min(ans, count);
        }
        dp[i][j]=ans;
        return ans;
    }

    //slight optimized code :
    public int minPalPartion22(String string, int i, int j)
    {
        if( i >= j || isPalindrome(string, i, j) )
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int minCut = string.length()-1, count;

        for(int k = i; k < j; k++)
        {
            if (isPalindrome(string, i, k)) {
                minCut = Math.min(minCut, 1 + minPalPartion(string, k + 1, j));
            }
        }
        dp[i][j]=minCut;
        return minCut;
    }



}
