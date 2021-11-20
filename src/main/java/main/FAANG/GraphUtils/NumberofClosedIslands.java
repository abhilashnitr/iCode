package main.FAANG.GraphUtils;

public class NumberofClosedIslands {

    /*
Approach 1: Flood Fill
First, we need to remove all land connected to the edges using flood fill.
Then, we can count and flood-fill the remaining islands.
    */
    int[] directions = new int[] {0, 1, 0, -1, 0};

    public int closedIsland(int[][] g) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (i == 0 || j == 0 || i == g.length - 1 || j == g[i].length - 1) {
                    fill(g, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < g.length; ++i) {
            for (int j = 0; j < g[i].length; ++j) {
                if (g[i][j] == 0) {
                    res++;
                    fill(g, i, j);
                }
            }
        }

        return res;
    }

    private void fill(int[][] g, int x, int y) {
        if (x < 0 || y < 0 || x >= g.length || y >= g[0].length || g[x][y] == 1)
            return;
        g[x][y] = 1;
        for (int i = 0; i < directions.length - 1; i++) {
            fill(g, x + directions[i], y + directions[i + 1]);
        }
    }

    //DFS
    boolean flag = true;
    public void dfs(int[][]grid, int i, int j) {

        if( i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]==1)
            return;

        //If other 0's are connected to border then dont increase ans
        if((i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1)
                && grid[i][j]==0)
            flag = false;

        grid[i][j]=1;

        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);

    }

    public int closedIslandDFS(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){

                if(grid[i][j]==0)
                {
                    dfs(grid,i,j);

                    //check if 0 isn't border/connected to border
                    if(flag)
                        ans+=1;
                    flag = true;
                }
            }
        }
        return ans;
    }

/*Union Find
Traverse all cells not on boundary of the grid; For each land with a land neighbor, if the neighbor belongs to open island, merge it into the open island; otherwise, merge the neighbor into the island including current cell;
Traverse all cells not on boundary of the grid again; Whenever encountering a land that its parent (id) is itself, then it is the root of the component (island), increase count by 1; The final value of the count is the number of closed island.
*/

}
