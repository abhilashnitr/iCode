package main.FAANG.ArrayUtils;

//Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray
// scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a
// cell has less than 8 surrounding cells, then use as many as you can.
public class ImageSmoother {

    public int[][] imageSmoother(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0){
            return M;
        }
        int[][] ans = new int[M.length][M[0].length];
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                ans[i][j] = helper(M, i, j);
            }
        }
        return ans;
    }
    private int helper(int[][] M, int x, int y){
        int sum = 0;
        int cnt = 0;
        int[][] next = {{-1, 0},{1, 0},
                {0, -1}, {0, 1},
                {1, -1}, {-1, 1},
                {1, 1}, {-1, -1},
                {0, 0}};
        for(int i = 0; i < 9; i++){
            int nx = x + next[i][0];
            int ny = y + next[i][1];
            if(nx >= 0 && nx < M.length && ny >= 0 && ny < M[0].length){
                sum += M[nx][ny];
                cnt++;
            }
        }
        return sum / cnt;
    }
}
