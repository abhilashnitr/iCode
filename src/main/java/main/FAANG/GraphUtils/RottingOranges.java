package main.FAANG.GraphUtils;
/*
You are given an m x n grid where each cell can have one of three values:
0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*/
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
     int[] dx = {0, 0, 1, -1};
     int[] dy = {1, -1, 0, 0};

    int orangesRotting(int[][] grid) {
        if(grid.length==0) return 0;
        int m = grid.length, n = grid[0].length, days = 0, tot = 0, cnt = 0;
        Queue<int[]> rotten = new LinkedList<>();
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                if(grid[i][j] != 0) tot++;
                if(grid[i][j] == 2) rotten.offer(new int[]{i, j});
            }
        }

        while(!rotten.isEmpty()){
            int k = rotten.size();
            cnt += k;
            while(k-->0){
                int x = rotten.peek()[0], y = rotten.peek()[1];
                rotten.poll();
                for(int i = 0; i < 4; ++i){
                    int nx = x + dx[i], ny = y + dy[i];
                    if(nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 1) continue;
                    grid[nx][ny] = 2;
                    rotten.offer(new int[]{nx, ny});
                }
            }
            if(!rotten.isEmpty()) days++;
        }

        return tot == cnt ? days : -1;
    }
}
