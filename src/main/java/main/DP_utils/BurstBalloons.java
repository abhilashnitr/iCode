package main.DP_utils;

//You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array
// nums. You are asked to burst all the balloons.
//
//If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of
// bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
//
//Return the maximum coins you can collect by bursting the balloons wisely.
public class BurstBalloons {

    //We then think can we apply the divide and conquer technique? After all there seems to be many self similar sub
    // problems from the previous analysis.
    //Well, the nature way to divide the problem is burst one balloon and separate the balloons into 2 sub sections one
    // on the left and one one the right. However, in this problem the left and right become adjacent and have effects
    // on the maxCoins in the future.
    //Then another interesting idea come up. Which is quite often seen in dp problem analysis. That is reverse thinking.
    // Like I said the coins you get for a balloon does not depend on the balloons already burst. Therefore
    //instead of divide the problem by the first balloon to burst, we divide the problem by the last balloon to burst.
    //Why is that? Because only the first and last balloons we are sure of their adjacent balloons before hand!
    //For the first we have nums[i-1]*nums[i]*nums[i+1] for the last we have nums[-1]*nums[i]*nums[n].
    //OK. Think about n balloons if i is the last one to burst, what now?
    //We can see that the balloons is again separated into 2 sections. But this time since the balloon i is the last
    // balloon of all to burst, the left and right section now has well defined boundary and do not affect each other!
    // Therefore we can do either recursive method with memoization or dp.

    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
    public int maxCoins2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][nums.length];
        for (int len = 1; len <= nums.length; len++) {
            for (int start = 0; start <= nums.length - len; start++) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    int coins = nums[i] * getValue(nums, start - 1) * getValue(nums, end + 1);
                    coins += i != start ? dp[start][i - 1] : 0; // If not first one, we can add subrange on its left.
                    coins += i != end ? dp[i + 1][end] : 0; // If not last one, we can add subrange on its right
                    dp[start][end] = Math.max(dp[start][end], coins);
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    private int getValue(int[] nums, int i) { // Deal with num[-1] and num[num.length]
        if (i < 0 || i >= nums.length) {
            return 1;
        }
        return nums[i];
    }
}
