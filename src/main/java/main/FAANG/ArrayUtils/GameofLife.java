package main.FAANG.ArrayUtils;

public class GameofLife {
    /*
    According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by
    the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead
(represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following
four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births
and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
*/

    int[][] dir ={{1,-1},{1,0},{1,1},{0,-1},{0,1},{-1,-1},{-1,0},{-1,1}};
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int live=0;
                for(int[] d:dir){
                    if(d[0]+i<0 || d[0]+i>=board.length || d[1]+j<0 || d[1]+j>=board[0].length) continue;
                    if(board[d[0]+i][d[1]+j]==1 || board[d[0]+i][d[1]+j]==2) live++;
                }
                if(board[i][j]==0 && live==3) board[i][j]=3;
                if(board[i][j]==1 && (live<2 || live>3)) board[i][j]=2;
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] %=2;
            }
        }
    }
}
