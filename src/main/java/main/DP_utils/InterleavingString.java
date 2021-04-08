package main.DP_utils;

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
}
