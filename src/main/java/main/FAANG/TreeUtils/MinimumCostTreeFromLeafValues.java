package main.FAANG.TreeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumCostTreeFromLeafValues {

    public static void main(String[] args) {
        int[] arr={6,2,4,8};
        System.out.println(mctFromLeafValues(arr));
    }

    public static int mctFromLeafValues(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }



    //dp[i][j]=dp[i][k]+dp[k][j]+max(A[i....k])*max(A[k....j])  k = i to < j

    public int mctFromLeafValuesDp(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        return dfs(arr, 0, n - 1, dp);
    }

    public int dfs(int[] arr, int s, int e, int[][] dp) {
        if (s == e) return 0;
        if (dp[s][e] > 0) return dp[s][e];
        int ans = Integer.MAX_VALUE;
        for (int i = s; i < e; i++) {
            int left = dfs(arr, s, i, dp);
            int right = dfs(arr, i + 1, e, dp);
            int maxLeft = 0, maxRight = 0;
            for (int j = s; j <= i; j++) maxLeft = Math.max(maxLeft, arr[j]);
            for (int j = i + 1; j <= e; j++) maxRight = Math.max(maxRight, arr[j]);
            ans = Math.min(ans, left + right + maxLeft * maxRight);
        }
        dp[s][e] = ans;
        return ans;
    }



}
