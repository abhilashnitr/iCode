package main.FAANG.GraphUtils;

import java.util.LinkedList;
import java.util.Queue;

//this question is very similar with 286 Walls and Gates, same logic.
/*
Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.
Example 1:
Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]
*/
public class Matrix01 {
    public static void main(String[] args) {

    }

    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = cur[0] + dir[i][0];
                int col = cur[1] + dir[i][1];
                if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
                    continue;
                }
                visited[row][col] = true;
                matrix[row][col] = matrix[cur[0]][cur[1]] + 1;
                queue.offer(new int[]{row, col});
            }
        }
        return matrix;
    }

    //Time complexity: O(n∗m)
    //
    //Space complexity: O(1)
    private static final int MAX_DISTANCE = 10_000;

    public int[][] updateMatrix2(int[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    mat[i][j] = 1 + minAbove(mat, i, j);
                }
            }
        }

        for (int i = mat.length - 1; i >= 0 ; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                mat[i][j] = Math.min(mat[i][j], 1 + minBelow(mat, i, j));
            }
        }

        return mat;
    }


    private int minAbove(int[][] mat, int x, int y) {
        return Math.min(
                x > 0 ? mat[x-1][y] : MAX_DISTANCE,
                y > 0 ? mat[x][y-1] : MAX_DISTANCE
        );
    }


    private int minBelow(int[][] mat, int x, int y) {
        return Math.min(
                (x + 1 < mat.length) ? mat[x+1][y] : MAX_DISTANCE,
                (y + 1 < mat[0].length) ? mat[x][y+1] : MAX_DISTANCE
        );
    }
}
