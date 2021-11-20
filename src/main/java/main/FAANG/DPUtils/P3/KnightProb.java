package main.FAANG.DPUtils.P3;

import java.util.Arrays;

public class KnightProb {

    public static void main(String[] args) {
        KnightProb knightProb= new KnightProb();
        System.out.println(knightProb.knightProbability2(3,2,0,0));
        System.out.println(knightProb.knightProbability(3,2,0,0));

    }

    public double knightProbability2(int N, int K, int r, int c) {
        // Use double because of overflow
        // dp[k][i][j] number of ways to move to (i, j) after k moves
        double[][] dp = new double[N][N];
        int[][] dirs = {{2, -1}, {2, 1}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};
        dp[r][c] = 1;
        double count = 0;
        for (int k = 0; k < K; k++) {
            double[][] dp2 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir: dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= N || y < 0 || y >= N) continue;
                        dp2[i][j] += dp[x][y];
                        // dp2[x][y] += dp[i][j]; also works
                    }
                }
            }
            dp = dp2;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count += dp[i][j];
            }
        }
        return count / (Math.pow(8, K));
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
