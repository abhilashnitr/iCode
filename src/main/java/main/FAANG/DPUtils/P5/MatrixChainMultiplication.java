package main.FAANG.DPUtils.P5;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 3};
        MatrixChainMultiplication mcm=new MatrixChainMultiplication();
        System.out.println(mcm.MatrixChainOrder(arr,1,arr.length-1));
    }

    int MatrixChainOrder(int p[], int i, int j)
    {
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++)
        {
            int count = MatrixChainOrder(p, i, k)
                    + MatrixChainOrder(p, k + 1, j)
                    + p[i - 1] * p[k] * p[j];

            if (count < min)
                min = count;
        }
        // Return minimum count
        return min;
    }

    //memorized
    static int[][] dp = new int[100][100];
    int matrixChainMemoised(int[] p, int i, int j)
    {
        if (i == j)
        {
            return 0;
        }
        if (dp[i][j] != -1)
        {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++)
        {
            dp[i][j] = Math.min(dp[i][j],
                              matrixChainMemoised(p, i, k)
                            + matrixChainMemoised(p, k + 1, j)
                            + p[i - 1] * p[k] * p[j]);
        }
        return dp[i][j];
    }
}
