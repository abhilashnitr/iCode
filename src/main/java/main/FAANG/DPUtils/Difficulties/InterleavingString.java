package main.FAANG.DPUtils.Difficulties;

import java.util.HashSet;

//Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        HashSet<Integer> cache = new HashSet<Integer>();
        return isInterleave0(s1, s2, s3, 0, 0, cache);
    }

    //This looks slow but is actually faster than BFS! Think about it carefully, in this
    //particular problem, search always ends at the same depth. DFS with memorization
    //searches about the same amount of paths with the same length as BFS, if it is doesn't
    //terminate on the first path found. Without the queue operations, the overall cost
    //is only smaller if we don't count call stack. The most significant runtime reducer is
    //probably the early termination

    private boolean isInterleave0(String s1, String s2, String s3, int p1, int p2, HashSet<Integer> cache) {
        if (p1 + p2 == s3.length())
            return true;
        if (cache.contains(p1 * s3.length() + p2))
            return false;
        // no need to store actual result.
        // if we found the path, we have already terminated.
        cache.add(p1 * s3.length() + p2);
        boolean match1 = p1 < s1.length() && s3.charAt(p1 + p2) == s1.charAt(p1);
        boolean match2 = p2 < s2.length() && s3.charAt(p1 + p2) == s2.charAt(p2);
        if (match1 && match2)
            return isInterleave0(s1, s2, s3, p1 + 1, p2, cache) ||
                    isInterleave0(s1, s2, s3, p1, p2 + 1, cache);
        else if (match1)
            return isInterleave0(s1, s2, s3, p1 + 1, p2, cache);
        else if (match2)
            return isInterleave0(s1, s2, s3, p1, p2 + 1, cache);
        else
            return false;
    }



    //DP
    public boolean isInterleave2(String s1, String s2, String s3) {

        if ((s1.length()+s2.length())!=s3.length()) return false;

        boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];

        matrix[0][0] = true;

        for (int i = 1; i < matrix[0].length; i++){
            matrix[0][i] = matrix[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < matrix.length; i++){
            matrix[i][0] = matrix[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                matrix[i][j] = (matrix[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
                        || (matrix[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }

        return matrix[s2.length()][s1.length()];

    }

    public static void main(String[] args) {
        String s1="abc";
        String s2="def";
        String s3="abcdef";

        InterleavingString interleavingString=new InterleavingString();
        System.out.println(interleavingString.isInterleave3(s1,s2,s3));
    }
    public boolean isInterleave3(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length();
        if(s3.length() != len1 + len2){
            return false;
        }
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for(int i = 1; i <= len1; i++){ //base case, go down
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i <= len2; i++){  //base case, go right
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                //case 1, special case, up and left has the same character.
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    //case2, normal case, only from left
                }else if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i - 1][j];
                    //case3, normal case, only from up
                }else if(s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i][j - 1];
                }
                /*pay attention, no other cases here,think of: s1 = abc, s2 = def, s3 = abcdef,
                while dp[2][1] will be one of "abd,adb, bad, bda, dab, dba", and we try to match "abc" no match!
                Think of this problem as a matrix, we are tring to find out if there is a path from [0,0]  to [len1 - 1, len2 - 1],
                so dp[i][j] == false, only mean dp[i][j] is not on the valid path, does not mean there is no such path exists!
                   a  b  c
                   ☑️ ☑️ ☑️
            d               ☑️
            e               ☑️
            f               ☑️(valid path)
            */
            }
        }
        return dp[len1][len2];
    }
}
