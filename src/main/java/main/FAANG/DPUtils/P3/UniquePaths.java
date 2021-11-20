package main.FAANG.DPUtils.P3;

public class UniquePaths {
    public int uniquePaths(int m, int n) {

        int dp[][]=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1)
                    obstacleGrid[i][j]=0;
                else if(i==0&&j==0){
                    obstacleGrid[i][j]=1;
                }else if(i==0){
                    obstacleGrid[0][j]=obstacleGrid[0][j-1];
                }
                else if(j==0){
                    obstacleGrid[i][0]=obstacleGrid[i-1][0];
                }else {
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[m-1][n-1];
    }
}
