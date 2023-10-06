package main.FAANG.GraphUtils;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
//Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
//The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
// Input 1: a maze represented by a 2D array
//0 0 1 0 0
//0 0 0 0 0
//0 0 0 1 0
//1 1 0 1 1
//0 0 0 0 0
//Input 2: start coordinate (rowStart, colStart) = (0, 4)
//Input 3: destination coordinate (rowDest, colDest) = (4, 4)
//Output: true
//Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.
public class TheMaze {

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return reach(maze, start[0], start[1] , destination, visited);
    }
    private boolean reach(int[][] maze, int i, int j, int[] dest, boolean[][] visited) {
        if (i == dest[0] && j == dest[1]) {
            return true;
        }
        if (visited[i][j] == true) {
            return false;
        }
        visited[i][j] = true;
        int[][] dirs = new int[4][2];
        dirs[0] = new int[]{0, 1};
        dirs[1] = new int[]{1, 0};
        dirs[2] = new int[]{0, -1};
        dirs[3] = new int[]{-1, 0};
        for (int k = 0; k < dirs.length; k ++) {
            int x = i, y = j;
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x = x + dirs[k][0];
                y = y + dirs[k][1];
            }
            x = x - dirs[k][0];
            y = y - dirs[k][1];
            if (!visited[x][y] && reach(maze, x, y, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    //BFS
    public boolean hasPathBFS(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = new int[][]{ {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
        Queue<int[]> queue = new LinkedList();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;

            // The furthest point in four directions
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];

                // move Furthest straight-line distance
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                // Furthest (x,y)
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }



    // Part 2 : Shortest path distance

    private class Point implements Comparable<Point>{
        public int x;
        public int y;
        public int step;
        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
        public int compareTo(Point p) {
            return this.step - p.step;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] dirs = new int[4][2];
        dirs[0] = new int[]{1, 0};
        dirs[1] = new int[]{0, 1};
        dirs[2] = new int[]{-1, 0};
        dirs[3] = new int[]{0, -1};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        PriorityQueue<Point> q = new PriorityQueue<Point>();
        q.add(new Point(start[0], start[1], 0));
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x == destination[0] && p.y == destination[1]) {
                return p.step;
            }
            visited[p.x][p.y] = true;
            for (int k = 0; k < dirs.length; k ++) {
                int i = p.x;
                int j = p.y;
                int count = 0;
                while (i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 0) {
                    i += dirs[k][0];
                    j += dirs[k][1];
                    count ++;
                }
                i -= dirs[k][0];
                j -= dirs[k][1];
                count --;
                if (visited[i][j] == false) {
                    q.add(new Point(i, j, p.step + count));
                }
            }
        }
        return -1;
    }
}


