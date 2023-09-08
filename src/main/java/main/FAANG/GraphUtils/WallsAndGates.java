package main.FAANG.GraphUtils;

import java.util.LinkedList;
import java.util.Queue;
//You are given a m x n 2D grid initialized with these three possible values.
//
//-1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room
//Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//INF  -1  0  INF
//INF INF INF  -1
//INF  -1 INF  -1
// 0   -1 INF INF
//After running your function, the 2D grid should be:
//
//  3  -1   0   1
//  2   2   1  -1
//  1  -1   2  -1
//  0  -1   3   4
public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }


    static int EMPTY = 2147483647;


    public void wallsAndGatesdfs(int[][] rooms) {
        if(rooms == null || rooms.length == 0) return;
        boolean visited[][] = new boolean[rooms.length][rooms[0].length];
        for(int i=0; i< rooms.length; i++){
            for(int j=0; j< rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    dfs(rooms, i, j, visited, 0);

                }
            }
        }
    }

    private void dfs(int[][] rooms, int x, int y, boolean[][] visited, int dis){

        if(x < 0 || x >= rooms.length
                || y < 0 || y >= rooms[0].length || rooms[x][y] == -1)
            return;
        if(visited[x][y] || dis > rooms[x][y]) return;

        rooms[x][y] = Math.min(rooms[x][y], dis);// since a room is already 0,
        // in first level, there is no set really.
        visited[x][y] = true;//  to avoid loop.
        dfs(rooms, x+1, y, visited, dis+1);
        dfs(rooms, x-1, y, visited, dis+1);
        dfs(rooms, x, y+1, visited, dis+1);
        dfs(rooms, x, y-1, visited, dis+1);
        visited[x][y] =false;

    }

    //the visited array is to avoid loop, which can be done by checking dis > rooms[x][y]
    //
    //Why dis > rooms[x][y] should return.
}
