package main.FAANG.GraphUtils;

/*
Given a 2-dimensional grid of integers, each value in the grid represents the color of the grid square at that location.

Two squares belong to the same connected component if and only if they have the same color and are next to each other in any of the 4 directions.

The border of a connected component is all the squares in the connected component that are either 4-directionally adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).

Given a square at location (r0, c0) in the grid and a color, color the border of the connected component of that square with the given color, and return the final grid.
*/
public class ColoringABorder {

    class Solution {
        public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

            int n = grid.length;
            int m = grid[0].length;

            if (grid[r0][c0]==color)
                return grid;

            boolean[][] visited = new boolean[n][m];
            dfs(grid, r0, c0, grid[r0][c0], visited, color, n, m);

            return grid;

        }

        public void dfs(int[][] grid, int i, int j, int col, boolean[][] visited, int target, int n, int m){

            if (i>n-1 || i<0 || j>m-1 || j<0 || grid[i][j]!=col || visited[i][j])
                return;

            visited[i][j] = true;
            boolean border = false;

            if (i==0 || j==0 || j==m-1 || i==n-1 || grid[i+1][j]!=col || grid[i-1][j]!=col || grid[i][j-1]!=col || grid[i][j+1]!=col)
                border = true;

            dfs(grid, i+1, j, col, visited, target, n, m);
            dfs(grid, i-1, j, col, visited, target, n, m);
            dfs(grid, i, j+1, col, visited, target, n, m);
            dfs(grid, i, j-1, col, visited, target, n, m);

            if (border)
                grid[i][j] = target;

        }
    }

}
