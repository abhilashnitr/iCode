package main.FAANG.GraphUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
//The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
//The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's heigh/t is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
//Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
public class PacificAtlanticWaterFlow {


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for (int col = 0; col< cols; col++){
            dfs(0, col, pacific, heights[0][col], heights);   // first row
            dfs(rows-1, col, atlantic, heights[rows-1][col], heights); // last row
        }

        for (int row = 0; row<rows; row++){
            dfs(row, 0, pacific, heights[row][0], heights);  // first col
            dfs(row, cols-1, atlantic, heights[row][cols-1], heights); // last col
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }

    private void dfs(int row, int col, boolean[][] visited, int prevHeight, int[][] heights){
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col] || prevHeight > heights[row][col])
            return;
        visited[row][col]= true;
        dfs(row+1, col, visited, heights[row][col], heights);
        dfs(row-1, col, visited, heights[row][col], heights);
        dfs(row, col+1, visited, heights[row][col], heights);
        dfs(row, col-1, visited, heights[row][col], heights);
    }

}
