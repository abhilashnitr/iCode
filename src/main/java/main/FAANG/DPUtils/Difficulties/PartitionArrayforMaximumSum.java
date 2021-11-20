package main.FAANG.DPUtils.Difficulties;

//Given an integer array arr, you should partition the array into (contiguous) subarrays of length at most k. After
// partitioning, each subarray has their values changed to become the maximum value of that subarray.
//Return the largest sum of the given array after partitioning.

//Example 1:
//Input: arr = [1,15,7,9,2,5,10], k = 3
//Output: 84
//Explanation: arr becomes [15,15,15,9,10,10,10]
public class PartitionArrayforMaximumSum {

    public static void main(String[] args) {
        int[] arr={1,15,7,9,2,5,10};
        int k=3;
        PartitionArrayforMaximumSum partitionArrayforMaximumSum=new PartitionArrayforMaximumSum();
        System.out.println(partitionArrayforMaximumSum.maxSumAfterPartitioning(arr,k));
    }
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length, dp[] = new int[N];
        for (int i = 0; i < N; ++i) {
            int curMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        return dp[N - 1];
    }
}
