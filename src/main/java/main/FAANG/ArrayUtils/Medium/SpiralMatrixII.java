package main.FAANG.ArrayUtils.Medium;

//Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
public class SpiralMatrixII {

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII=new SpiralMatrixII();
        spiralMatrixII.spiralOrder(3);
    }

    public int[][]  spiralOrder(int n) {



        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1;
        int[][] matrix = new int[n][n];
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
               matrix[rowBegin][j] = num++;
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                matrix[j][colEnd] = num++;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    matrix[rowEnd][j] = num++;
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    matrix[j][colBegin] = num++;
                }
            }
            colBegin ++;
        }

            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    System.out.print( matrix[i][j]+" ");
                }
                System.out.println();
            }
        return matrix;
    }
}
