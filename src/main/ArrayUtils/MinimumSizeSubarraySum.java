package main.ArrayUtils;
/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
*/
public class MinimumSizeSubarraySum {



  public static void main(String[] args) {
    int[] x={5,10,10};
    System.out.println(minSubArrayLen(5,x));
  }

  public static int MaxSubArrayLen(int s, int[] a) {
    if (a == null || a.length == 0)
      return 0;

    int i = 0, j = 0, sum = 0, min = Integer.MIN_VALUE;

    while (j < a.length) {
      sum += a[j++];

      while (sum > s) {
        min = Math.max(min, j - i-1);
        sum -= a[i++];
      }
    }

    return min == Integer.MIN_VALUE ? 0 : min;
  }
  //O(N) - keep a moving window expand until sum>=s, then shrink util sum<s. Each time after
  // shrinking, update length. (similar to other solutions, just removed unnecessary min value
  // assignment)
  public static int minSubArrayLen(int s, int[] a) {
    if (a == null || a.length == 0)
      return 0;

    int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

    while (j < a.length) {
      sum += a[j++];

      while (sum >= s) {
        min = Math.min(min, j - i);
        sum -= a[i++];
      }
    }

    return min == Integer.MAX_VALUE ? 0 : min;
  }

}
