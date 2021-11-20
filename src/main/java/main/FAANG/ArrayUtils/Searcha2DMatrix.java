package main.FAANG.ArrayUtils;

//Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
public class Searcha2DMatrix {

    public static void main(String[] args) {
        int[][]  arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        searchMatrix(arr,3);
    }
    static boolean searchMatrix(int[][] matrix, int target) {
        int x=1;
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0, r = m * n - 1;
        while (l != r){
            int mid = (l + r - 1) >> 1;
            int row=mid/m;    //m is the no of columns
            int col=mid%m;
            if (matrix[row][col] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return matrix[r / m][r % m] == target;
    }
}
