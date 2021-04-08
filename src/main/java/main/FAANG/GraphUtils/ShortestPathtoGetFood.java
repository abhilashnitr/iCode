package main.FAANG.GraphUtils;
/*
You are starving and you want to eat food as quickly as possible. You want to find the shortest path to arrive at any food cell.
You are given an m x n character matrix, grid, of these different types of cells:
'*' is your location. There is exactly one '*' cell.
'#' is a food cell. There may be multiple food cells.
'O' is free space, and you can travel through these cells.
'X' is an obstacle, and you cannot travel through these cells.
You can travel to any adjacent cell north, east, south, or west of your current location if there is not an obstacle.
Return the length of the shortest path for you to reach any food cell. If there is no path for you to reach food, return -1.
*/

import java.util.LinkedList;
import java.util.Queue;

//idea is clearly to use bfs to finnd the shortest path quickly
public class ShortestPathtoGetFood {

    public int getFood(char[][] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length;
        boolean[][] visited = new boolean[rLen][cLen];
        Queue<int[]> q = new LinkedList<>();
        outer:
        for (int r = 0; r < rLen; r++) {
            for (int c = 0; c < cLen; c++) {
                if (grid[r][c] == '*') {
                    q.add(new int[]{r, c});
                    visited[r][c] = true;
                    break outer;
                }
            }
        }
        final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int layer = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (inBounds(grid, nr, nc) && !visited[nr][nc]) {
                        if (grid[nr][nc] == '#') {
                            return layer;
                        } else if (grid[nr][nc] == 'O') {
                            q.add(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            layer++;
        }
        return -1;
    }

    boolean inBounds(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 ||
                r >= grid.length ||
                c >= grid[0].length) {
            return false;
        }
        return true;
    }
}
