package DP_utils;

public class MaxSubSquareAll1s {

  public static void main(String[] args) {
    int[][] M =
        {
            { 0, 0, 1, 0, 1, 1 },
            { 0, 1, 1, 1, 0, 0 },
            { 0, 0, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 1 },
            { 1, 0, 1, 1, 1, 1 },
            { 1, 1, 1, 0, 1, 1 }
        };


    System.out.print("The size of largest square sub-matrix of 1's is " + findLargestSquare(M));
  }

  private static int findLargestSquare(int[][] M) {

    int[][] T = new int[M.length][M[0].length];
    int max = 0;
    int max_i = 0;
    int max_j = 0;
    for (int i = 0; i < M.length; i++)
    {
      for (int j = 0; j < M[0].length; j++)
      {
        T[i][j] = M[i][j];

        // if we are not at the first row or first column and
        // current cell has value 1
        if (i > 0 && j > 0 && M[i][j] == 1)
        {
          // largest square sub-matrix ending at M[i][j] will be
          // 1 plus minimum of largest square sub-matrix
          // ending at M[i][j-1], M[i-1][j] and M[i-1][j-1]

          T[i][j] = minimum(T[i][j - 1], T[i - 1][j],
              T[i - 1][j - 1]) + 1;
        }

        // update maximum size found so far
        if (max < T[i][j]) {
          max = T[i][j];
          max_i=i;
          max_j=j;
        }
      }
    }

    for(int i=max_i;i>max_i-max;i--){
      for(int j=max_j;j>max_j-max;j--){
        System.out.print(M[i][j]+" ");
      }
      System.out.println("");
    }
    return max;
  }

  public static int minimum (int x, int y, int z) {
    return Integer.min(Integer.min(x, y), z);
  }
}
