package main.FAANG.DPUtils.P1;

public class LongestPalindromicSubstring {

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
                    table[i][j]= s.charAt(i) == s.charAt(j);

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
