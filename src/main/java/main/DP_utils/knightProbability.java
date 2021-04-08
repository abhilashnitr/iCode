package main.DP_utils;

import java.util.Arrays;

public class knightProbability {

    int [][] direction =new int[][]{{2,1},{-2,1},{2,-1},{-2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};

    public static void main(String[] args) {
        knightProbability k= new knightProbability();
        System.out.println(k.knightProbability(3,2,0,0));
    }

    int[][] moves = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};
    public double knightProbability(int N, int K, int r, int c) {
        int len = N;
        double dp0[][] = new double[len][len];
        for(double[] row : dp0) Arrays.fill(row, 1);
        for(int l = 0; l < K; l++) {
            double[][] dp1 = new double[len][len];
            for(int i = 0; i < len; i++) {
                for(int j = 0; j < len; j++) {
                    for(int[] move : moves) {
                        int row = i + move[0];
                        int col = j + move[1];
                        if(isLegal(row, col, len)) dp1[i][j] += dp0[row][col];
                    }
                }
            }
            dp0 = dp1;
        }
        return dp0[r][c] / Math.pow(8, K);
    }
    private boolean isLegal(int r, int c, int len) {
        return r >= 0 && r < len && c >= 0 && c < len;
    }
}
