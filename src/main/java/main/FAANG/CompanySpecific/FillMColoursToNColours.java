package main.FAANG.CompanySpecific;

//https://www.geeksforgeeks.org/ways-to-fill-n-positions-using-m-colors-such-that-there-are-exactly-k-pairs-of-adjacent-different-colors/
public class FillMColoursToNColours {


    //countWays(index + 1, cnt), if the next index is filled with the same color.
    //(m – 1) * countWays(index + 1, cnt + 1), if the next index is filled with a different color. The number of ways is multiplied by (m – 1).
    static int countWays(int index, int cnt, int dp[][], int n, int m, int k)
    {

        // When all positions are filled
        if (index == n) {

            // If adjacent pairs are exactly K
            if (cnt == k)
                return 1;
            else
                return 0;
        }

        // If already calculated
        if (dp[index][cnt] != -1)
            return dp[index][cnt];

        int ans = 0;

        // Next position filled with same color
        ans += countWays(index + 1, cnt, dp, n, m, k);

        // Next position filled with different color
        // So there can be m-1 different colors
        ans += (m - 1) * countWays(index + 1, cnt + 1, dp, n, m, k);

        return dp[index][cnt] = ans;
    }

    // Driver Code
    public static void main(String args[])
    {
        int n = 3, m = 2, k = 2;
        int dp[][]= new int [n + 1][k+1];
        for(int i=0;i<n+1;i++)
            for(int j=0;j<k+1;j++)
                dp[i][j]=-1;

        System.out.println(m * countWays(1, 0, dp, n, m, k));
    }

}
