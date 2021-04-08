package Practise;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PracticeDP {

    public static void main(String[] args) {
        PracticeDP p=new PracticeDP();
        String s="leetcode";
        System.out.println(s.substring(0,4));

        int[] arr= {2,1,5,6,2,3};

        System.out.println(p.wordBreak("leetcode", Arrays.asList("leet","code")));
        //String str=p.longestPalindrome("babad");
//        int str=p.longestCommonSubsequence("abcde","ace");
//        System.out.println(str);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int index=0;
        int n=s.length();
        if(n==0||wordDict.size()==0)
            return false;

        boolean dp[]=new boolean[n+1];

        dp[0]=true;

        for(index=0;index<s.length();index++){
            if(!dp[index])
                continue;
            for(String word:wordDict){
                int h=index+word.length();
                if(h<=n&&s.substring(index,h).equals(word))
                    dp[h]=true;
            }
        }


        return dp[n];
    }

    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st=new Stack();
        st.push(heights[0]);
        int maxarea=0;
        for(int i=1;i<=heights.length;i++){
            int h=(i==heights.length)?0:heights[i];
            if(st.isEmpty()||h>=heights[st.peek()]){
                st.push(i);
            }else{
                int t=st.pop();
                maxarea=Math.max(maxarea,heights[t]*(st.isEmpty()?i:i-1-st.peek()));
            }
        }
        return maxarea;

    }


    public int longestCommonSubsequence(String text1, String text2) {

        int n1=text1.length();
        int n2=text2.length();
        int dp[][]=new int[n1+1][n2+1];


        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                if(i==0||j==0) {
                    dp[i][j] = 0;
                    continue;
                }
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n1][n2];
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
        return dp[n-1][n-1];

    }

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

    public String longestPalindrome(String s) {

        int n = s.length();
        boolean table[][]= new boolean[n][n];
        int maxlen=1;
        int start=0;
        for(int i=0;i<n;i++){
            table[i][i]=true;
        }
        for(int l=2;l<=n;l++){
            for(int i=0;i<n-l+1;i++){
                int j=i+l-1;
                if(i==j-1){
                    table[i][j]=(s.charAt(i)==s.charAt(j))?true:false;
                }
                else{
                    if(s.charAt(i)==s.charAt(j)&&table[i+1][j-1]){
                        table[i][j]=true;

                    }else{
                        table[i][j]=false;
                    }
                }
                if(table[i][j]&&j-i+1>maxlen){
                    maxlen=j-i+1;
                    start=i;
                }
            }
        }
        return s.substring(start,start+maxlen);
    }

}

