package main.FAANG.DPUtils.P1;

public class DistinctSubsequences {
    public static void main(String[] args) {
        DistinctSubsequences distinctSubsequences=new DistinctSubsequences();
        String s="subsequence";
        String t="";
        System.out.println(distinctSubsequences.numDistinct2(s,t));
    }

    public int numDistinct(String S, String T) {

        if(T.length()==0)
            return 1;

        if(S.length()==0)
            return 0;


        return helper(S,T,0,0);
    }

    private int helper(String s, String t, int i, int j) {
        if(t.length()-1==j)
            return 1;

        if(s.length()-1==i)
            return 0;

        if(s.charAt(i)==t.charAt(j))
            return helper(s,t,i+1,j+1)+helper(s,t,i+1,j);
        else
            return helper(s,t,i+1,j);

    }


    public int numDistinct2(String S, String T) {
        // array creation
        int[][] mem = new int[S.length()+1][T.length()+1];

        // filling the first row: with 1s
        for(int j=0; j<=S.length(); j++) {
            mem[j][0] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.
        for(int i=1; i<=S.length(); i++) {
            for(int j=1; j<=T.length(); j++) {
                if(T.charAt(j-1) == S.charAt(i-1)) {
                    mem[i][j] = mem[i-1][j-1] + mem[i-1][j];
                } else {
                    mem[i][j] = mem[i-1][j];
                }
            }
        }

        return mem[S.length()][T.length()];
    }

}
