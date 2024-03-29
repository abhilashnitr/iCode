package main.FAANG.DPUtils.Difficulties;

import java.util.Arrays;

//This problem is a typical 0-1 knapsack problem, we need to pick several strings in provided strings to get the maximum
// number of strings using limited number 0 and 1. We can create a three dimensional array, in which dp[i][j][k] means
// the maximum number of strings we can get from the first i argument strs using limited j number of '0's and k number
// of '1's.
//
//For dp[i][j][k], we can get it by fetching the current string i or discarding the current string, which would result
// in dp[i][j][k] = dp[i-1][j-numOfZero(strs[i])][i-numOfOnes(strs[i])] and dp[i][j][k] = dp[i-1][j][k]; We only need to
// treat the larger one in it as the largest number for dp[i][j][k].
public class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][][] dp = new int[l+1][m+1][n+1];

        for (int i = 0; i < l+1; i++) {
            int[] nums = new int[]{0,0};
            if (i > 0) {
                nums = calculate(strs[i-1]);
            }
            for (int j = 0; j < m+1; j++) {
                for (int k = 0; k < n+1; k++) {
                    if (i == 0) {
                        dp[i][j][k] = 0;
                    } else if (j>=nums[0] && k>=nums[1]) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-nums[0]][k-nums[1]]+1);
                    } else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }

        return dp[l][m][n];
    }

    private int[] calculate(String str) {
        int[] res = new int[2];
        Arrays.fill(res, 0);

        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                res[0]++;
            } else if (ch == '1') {
                res[1]++;
            }
        }

        return res;
    }

    //By the way, 0-1 knapsack we cannot decrease the time complexity, but we can decrease the space complexity from ijk to j*k

    public int findMaxForm2(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], 0);
        }

        int[] nums;
        for (String str : strs) {
            nums = calculate(str);
            for (int j = m; j >= nums[0]; j--) {
                for (int k = n; k >= nums[1]; k--) {
                    if (j>=nums[0] && k>=nums[1]) {
                        dp[j][k] = Math.max(dp[j][k], dp[j-nums[0]][k-nums[1]]+1);
                    } else {
                        dp[j][k] = dp[j][k];
                    }
                }
            }
        }

        return dp[m][n];
    }



}
