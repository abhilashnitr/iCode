package main.FAANG.GraphUtils;

import java.util.LinkedList;
import java.util.Queue;

/*
Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected
4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
*/
public class MaxAreaofIsland {

    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        int m=grid.length,n=grid[0].length;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==1){
                    //max=Math.max(max,dfs(grid,i,j));
                    max=Math.max(max,bfs(grid,i,j));
                }
            }
        }
        return max;
    }
    private int dfs(int[][] grid, int i, int j){
        int m=grid.length,n=grid[0].length;
        if(i<0||i>=m||j<0||j>=n||grid[i][j]==0) return 0;
        grid[i][j]=0;
        int res=1;
        for (int[] dir:dirs){
            int i1=dir[0]+i;
            int j1=dir[1]+j;
            res+=dfs(grid,i1,j1);
        }
        return res;
    }
    private int bfs(int[][] grid, int i, int j){
        int m=grid.length,n=grid[0].length;
        if(grid[i][j]==0) return 0;
        grid[i][j]=0;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{i,j});
        int res=1;
        while(!q.isEmpty()){
            int[] pos=q.poll();
            for (int[] dir:dirs){
                int x=dir[0]+pos[0];
                int y=dir[1]+pos[1];
                if(x<0||x>=m||y<0||y>=n||grid[x][y]==0){
                    continue;
                }
                grid[x][y]=0;
                res++;
                q.offer(new int[]{x,y});
            }
        }
        return res;
    }
}
