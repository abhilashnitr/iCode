package main.DP_utils;

public class SpiralOrdertraversal {

  private static void printSpiralOrder(int[][] mat)
  {
    int top = 0, bottom = mat.length - 1;
    int left = 0, right = mat[0].length - 1;

    while (true)
    {
      if (left > right) {
        break;
      }

      // print top row
      for (int i = left; i <= right; i++) {
        System.out.print(mat[top][i] + " ");
      }
      top++;

      if (top > bottom) {
        break;
      }

      // print right column
      for (int i = top; i <= bottom; i++) {
        System.out.print(mat[i][right] + " ");
      }
      right--;

      if (left > right) {
        break;
      }

      // print bottom row
      for (int i = right; i >= left; i--) {
        System.out.print(mat[bottom][i] + " ");
      }
      bottom--;

      if (top > bottom) {
        break;
      }

      // print left column
      for (int i = bottom; i >= top; i--) {
        System.out.print(mat[i][left] + " ");
      }
      left++;
    }
  }


}
