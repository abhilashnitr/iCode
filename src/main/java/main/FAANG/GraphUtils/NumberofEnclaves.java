package main.FAANG.GraphUtils;

import main.FAANG.DPUtils.P2.NumberofDiceRollsWithTargetSum;

/*
Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)
A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.
Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.
*/
public class NumberofEnclaves {
    public static void main(String[] args) {
        NumberofEnclaves numberofEnclaves=new NumberofEnclaves();
        int[][] mat={{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(numEnclaves(mat));
    }
    public static int numEnclaves(int[][] A) {
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                if(i == 0 || j == 0 || i == A.length - 1 || j == A[i].length - 1)
                    dfs(A, i, j);
            }
        }

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[i].length; j++) {
                if(A[i][j] == 1)
                    result++;
            }
        }

        return result;
    }

    public static void dfs(int a[][], int i, int j) {

        if(i < 0 || i > a.length - 1 || j < 0 || j > a[i].length - 1||a[i][j] == 0)
            return;

            a[i][j] = 0;
            dfs(a, i + 1, j);
            dfs(a, i - 1, j);
            dfs(a, i, j + 1);
            dfs(a, i, j - 1);

    }
}
