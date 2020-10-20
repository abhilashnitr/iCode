package main.ArrayUtils;

public class MaximumSumCircularSubarray {
  public static void main (String[] args) {
  int[] x={8, -8, 9, -9, 10, -11, 12};
  System.out.println(maxSubarraySumCircular(x));

  }

  public static int maxSubarraySumCircular(int[] A) {
    int total = 0, maxSum = A[0], curMax = 0, minSum = A[0], curMin = 0;
    for (int a : A) {
      curMax = Math.max(curMax + a, a);
      maxSum = Math.max(maxSum, curMax);
      curMin = Math.min(curMin + a, a);
      minSum = Math.min(minSum, curMin);
      total += a;
    }
    return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
  }

  /*
Maximum sum is either max (we get using kadane's algo) or (sum - min).
There is a special case, if sum == min,
then maximum sum is max.
Let's develop an algorithm to solve this problem.
1. Find maximum subarray sum using kadane's algorithm (max)
2. Find minimum subarray sum using kadane's algorithm (min)
3. Find total sum of the array (sum)
4. Now, if sum == min return max
5. Otherwise, return maximum ( max, sum - min )
  */
}
