package DP_utils;

public class MaxRectangle extends LargestAreaInHistogram {

  public static void main(String[] args)
  {
    int R = 4;
    int C = 4;

    int A[][] = {
        { 0, 1, 1, 0 },
        { 1, 1, 1, 1 },
        { 1, 1, 1, 1 },
        { 1, 1, 0, 0 },
    };
    System.out.print("Area of maximum rectangle is " + maxRectangle(R, C, A));
  }



    static int maxRectangle(int R, int C, int A[][])
    {
      // Calculate area for first row and initialize it as
      // result
      int result = getMaxArea(A[0],C);

      // iterate over row to find maximum rectangular area
      // considering each row as histogram
      for (int i = 1; i < R; i++) {

        for (int j = 0; j < C; j++)

          // if A[i][j] is 1 then add A[i -1][j]
          if (A[i][j] == 1)
            A[i][j] += A[i - 1][j];

        // Update result if area with current row (as last
        // row of rectangle) is more
        result = Math.max(result, getMaxArea(A[i],C));
      }

      return result;
    }



}
