package main.FAANG.DPUtils.Difficulties;

public class LargestSumAverages {

    //https://leetcode.com/problems/largest-sum-of-averages/discuss/126280/Naive-Detailed-Step-by-Step-Approach-from-Recursive-to-DP-O(N)-solution


    public double largestSumOfAverages(int[] A, int K) {
        if (K == 0 || A.length == 0) {
            return 0;
        }
        int l = A.length;
        double[][] f = new double[l][K + 1];
        double[] s = new double[l + 1];
        for (int i = 1; i <= l; i++) {
            s[i] = s[i - 1] + A[i - 1];
            f[i - 1][1] =  s[i] / i;
        }
        for (int j = 2; j <= K; j++) {
            for (int i = 0; i < l; i++) {
                double max = Double.MIN_VALUE;
                for (int p = 0; p < i; p++) {
                    double sum = f[p][j - 1] + (s[i + 1] - s[p + 1]) / (i - p);
                    max = Double.max(sum, max);
                }
                f[i][j] = max;
            }
        }
        return f[l - 1][K];
    }

    public double largestSumOfAverages1(int[] A, int K) {
        int[] sum = new int[A.length];
        for (int i = 0;i < A.length; i++) sum[i] = A[i] + (i > 0 ? sum[i-1] : 0);
        return h(A, K, sum, A.length, 0);
    }

    public double h(int[] A, int k, int[] sum, int len, int s) {
        if (k == 1) return ((double)(sum[len-1] - sum[s] + A[s]) / (len-s));
        double num = 0;
        for (int i = s; i + k <= len ; i++) {
            num = Math.max(num, ((double) (sum[i] - sum[s] + A[s]) / (i - s + 1)) + h(A, k-1, sum, len, i+1));
        }
        return num;
    }

    public double largestSumOfAverages2(int[] A, int K) {
        int[] sum = new int[A.length];
        for (int i = 0;i < A.length; i++) sum[i] = A[i] + (i > 0 ? sum[i-1] : 0);
        double[][] dp = new double[A.length][K+1];
        return h(A, K, sum, dp, A.length, 0);
    }

    public double h(int[] A, int k, int[] sum, double[][] dp, int len, int s) {
        if (dp[s][k] != 0) return dp[s][k];
        if (k == 1){
            dp[s][k] = ((double)(sum[len-1] - sum[s] + A[s]) / (len-s));
            return dp[s][k];
        }
        for (int i = s; i + k <= len ; i++) {
            dp[s][k] = Math.max(dp[s][k], ((double) (sum[i] - sum[s] + A[s]) / (i - s + 1)) + h(A, k-1, sum, dp, len, i+1));
        }
        return dp[s][k];
    }
}
