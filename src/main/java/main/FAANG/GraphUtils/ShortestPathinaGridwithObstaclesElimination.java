package main.FAANG.GraphUtils;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//BFS O(MNK) time | O(MNK) space
public class ShortestPathinaGridwithObstaclesElimination {
    int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList();
        boolean[][][] visited = new boolean[n][m][k+1];
        visited[0][0][0] = true;
        q.offer(new int[]{0,0,0});
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] info = q.poll();
                int r = info[0], c = info[1], curK = info[2];
                if(r==n-1 && c==m-1){
                    return res;
                }
                for(int[] dir : dirs){
                    int nextR = dir[0] + r;
                    int nextC = dir[1] + c;
                    int nextK = curK;
                    if(nextR>=0 && nextR<n && nextC>=0 && nextC<m){
                        if(grid[nextR][nextC]==1){
                            nextK++;
                        }
                        if(nextK<=k && !visited[nextR][nextC][nextK]){
                            visited[nextR][nextC][nextK] = true;
                            q.offer(new int[]{nextR, nextC, nextK});
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }



  //  All the cells would be visited more than once as we could reach same cell with more distance but less obstacles which could be helpful later in traversal so we need to consider all the paths passing through same cell even with more distance.
  //  Using PQ doesn't make sense here due to reason no 1. so we are better off with simple queue without any comparator.
  //  Here we can also use 2D array for visited[m][n] = obstacles_till_here, then you will have to check if you find some cell with lesser no of obstacles reaching this point then consider that path. 3D array makes life easier in contest, but in interview its better to discuss about space constraints
    /*
Because we are trying to find the shortest path, use BFS here to exit immediately when a path reaches the bottom right most cell.
Use a set to keep track of already visited paths. We only need to keep track of the row, column, and the eliminate obstacle usage count. We don't need to keep track of the steps because remember we are using BFS for the shortest path. That means there is no value storing a 4th piece of the data, the current steps. This will reduce the amount of repeat work.
m = rows
n = columns
k = allowed elimination usages
Time Complexity
O(m*n*k) time complexity
This is because for every cell (m*n), in the worst case we have to put that cell into the queue/bfs k times.
Runtime: 68 ms, faster than 33.33% of Python3 online submissions
Space Complexity
O(m*n*k) space complexity
This is because for every cell (m*n), in the worst case we have to put that cell into the queue/bfs k times which means we need to worst case store all of those steps/paths in the visited set.
    */

    public int shortestPath2(int[][] grid, int k) {
        int step = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] seen = new int[m][n]; // min obstacles elimination from (0,0) to (x, y)
        for (int i = 0; i < m; i++) {
            Arrays.fill(seen[i], Integer.MAX_VALUE);
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        seen[0][0] = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return step;
                }
                for (int[] dir : DIRS) {
                    int x = dir[0] + cur[0];
                    int y = dir[1] + cur[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    int o = grid[x][y] + cur[2];
                    if (o >= seen[x][y] || o > k) {
                        continue;
                    }
                    seen[x][y] = o;
                    q.offer(new int[]{x, y, o});
                }
            }
            ++step;
        }
        return -1;
    }
}
