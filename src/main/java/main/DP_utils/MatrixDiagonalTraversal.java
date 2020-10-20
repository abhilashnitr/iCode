package main.DP_utils;

import java.util.ArrayList;
import java.util.Collections;

public class MatrixDiagonalTraversal {


    public static void main(String[] args) {
      int M[][] = {
          {1, 2, 3, 4},     {5, 6, 7, 8},     {9, 10, 11, 12},
          {13, 14, 15, 16}, {17, 18, 19, 20},
      };
      System.out.print("Given matrix is \n");
      printMatrix(M);

      System.out.print("\nDiagonal printing of matrix is \n");
      int[] result=diagonalOrder(M);
      for(int a:result){
        System.out.print(a+" ");
      }
      alternatediagonalOrder(M);
    }

  private static void alternatediagonalOrder (int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return ;
    }

    // Variables to track the size of the matrix
    int N = matrix.length;     //ROW
    int M = matrix[0].length;  //COL

    int k = 0;

    for (int d = 0; d < N + M - 1; d++) {

      int r = d < N ? d : N-1;
      int c = d < N ? 0 : d-M;
      while (r > -1 && c < M) {
        System.out.print(matrix[r][c]+" ");
        --r;
        ++c;
      }
      System.out.println(" ");
    }
  }

  private static int[] diagonalOrder (int[][] matrix) {
    // Check for empty matrices
    if (matrix == null || matrix.length == 0) {
      return new int[0];
    }

    // Variables to track the size of the matrix
    int N = matrix.length;     //ROW
    int M = matrix[0].length;  //COL

    // The two arrays as explained in the algorithm
    int[] result = new int[N*M];
    int k = 0;
    ArrayList<Integer> intermediate = new ArrayList<Integer>();

    // We have to go over all the elements in the first
    // row and the last column to cover all possible diagonals
    for (int d = 0; d < N + M - 1; d++) {

      // Clear the intermediate array every time we start
      // to process another diagonal
      intermediate.clear();

      // We need to figure out the "head" of this diagonal
      // The elements in the first row and the last column
      // are the respective heads.
      int r = d < M ? 0 : d - M + 1;
      int c = d < M ? d : M - 1;

      // Iterate until one of the indices goes out of scope
      // Take note of the index math to go down the diagonal
      while (r < N && c > -1) {
        intermediate.add(matrix[r][c]);
        System.out.print(matrix[r][c]+" ");
        ++r;
        --c;
      }
      System.out.println(" ");
      // Reverse even numbered diagonals. The
      // article says we have to reverse odd
      // numbered articles but here, the numbering
      // is starting from 0 :P
      if (d % 2 == 0) {
        Collections.reverse(intermediate);
      }

      for (int i = 0; i < intermediate.size(); i++) {
        result[k++] = intermediate.get(i);
      }
    }
    return result;
  }

  static void printMatrix(int matrix[][]) {
      for (int i = 0; i < matrix.length; i++) {
        for (int j = 0; j < matrix[0].length; j++)
          System.out.print(matrix[i][j] + " ");
        System.out.print("\n");
      }
    }
  

}
