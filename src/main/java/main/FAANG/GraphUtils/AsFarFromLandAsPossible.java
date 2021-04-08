package main.FAANG.GraphUtils;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance
to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.
The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
*/
public class AsFarFromLandAsPossible {
    public static void main(String[] args) {

    }
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int res = -1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir: dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x >= 0 && x <n && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    grid[x][y] = grid[cell[0]][cell[1]] + 1;
                    res = Math.max(grid[x][y], res);
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return res > 0? res - 1: -1;
    }
}
