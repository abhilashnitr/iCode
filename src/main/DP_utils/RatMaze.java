package main.DP_utils;

public class RatMaze {

    static  int N;
    public static void main(String[] args) {
        int maze[][] ={ { 1, 0, 0, 0 },
                        { 1, 1, 0, 1 },
                        { 0, 1, 0, 0 },
                        { 1, 1, 1, 1 } };

        N = maze.length;
        solveMaze(maze);
    }

    private static void solveMaze(int[][] maze) {

        int sol[][]=new int[N][N];

            if(!solveMazeUtil(sol,maze,0,0))
            System.out.println("solution does not exist");
            else
            System.out.println("Solution is right there");


        printSolution(sol);
    }

    static void printSolution(int sol[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + sol[i][j] + " ");
            System.out.println();
        }
    }

    private static boolean solveMazeUtil(int[][] sol, int[][] maze, int x, int y) {
        if(x==N-1&&y==N-1){
            sol[x][y]=1;
            return true;
        }
        if(isSafe(x,y,maze)){
            sol[x][y]=1;
            if(solveMazeUtil(sol,maze,x+1,y))
                return true;
            if(solveMazeUtil(sol,maze,x,y+1))
                return true;
            return false;
        }
        return false;
    }

    private static boolean isSafe(int x, int y,int[][] maze) {
        if(x>=0&&x<N&&y>=0&&y<N&&maze[x][y]==1)
            return true;
        return false;
    }
}
