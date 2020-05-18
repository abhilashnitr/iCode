package DP_utils;

public class MatrixSearchSorted {

  public static void main (String[] args) {
    int mat[][] = { { 10, 20, 30, 40 },
        { 15, 23, 35, 45 },
        { 25, 29, 37, 48 },
        { 32, 33, 39, 50 } };

    MatrixSearchSorted m= new MatrixSearchSorted();
    m.search(mat,4,25);

  }
  private void search(int[][] mat, int n, int x)
  {

    int i = 0, j = n - 1; // set indexes for top right
    // element

    while (i < n && j >= 0) {
      if (mat[i][j] == x) {
        System.out.print("n Found at " + i + " " + j);
        return;
      }
      if (mat[i][j] > x)
        j--;
      else // if mat[i][j] < x
        i++;
    }

    System.out.print("n Element not found");
    return; // if ( i==n || j== -1 )
  }

  public boolean searchMatrix(int[][] matrix, int target) {

    int row_num = matrix.length;
    int col_num = matrix[0].length;

    int begin = 0, end = row_num * col_num - 1;

    while(begin <= end){
      int mid = (begin + end) / 2;
      int mid_value = matrix[mid/col_num][mid%col_num];

      if( mid_value == target){
        return true;

      }else if(mid_value < target){
        //Should move a bit further, otherwise dead loop.
        begin = mid+1;
      }else{
        end = mid-1;
      }
    }

    return false;
  }

}
