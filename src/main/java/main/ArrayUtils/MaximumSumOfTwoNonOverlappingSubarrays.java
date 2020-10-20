package main.ArrayUtils;

public class MaximumSumOfTwoNonOverlappingSubarrays {


  public static void main(String[] args) {
    int[] ar={2,5,1,2,7,3,0};
    System.out.println(maxSumTwoNoOverlap2(ar,2,1));

  }


  public static int maxSumTwoNoOverlap2(int[] A, int L, int M) {
    for (int i = 1; i < A.length; ++i)
      A[i] += A[i - 1];
    int res = A[L + M - 1], Lmax = A[L - 1], Mmax = A[M - 1];
    for (int i = L + M; i < A.length; ++i) {
      Lmax = Math.max(Lmax, A[i - M] - A[i - L - M]);
      Mmax = Math.max(Mmax, A[i - L] - A[i - L - M]);
      res = Math.max(res, Math.max(Lmax + A[i] - A[i - M], Mmax + A[i] - A[i - L]));
    }
    return res;
  }

  public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
    return Math.max (calculate(A, L, M),calculate(A, M, L) );
  }

  public static int calculate(int[] A, int L, int M) {

    int[] left = new int[A.length+1];
    int[] right = new int[A.length+1];
    int res = 0;

    int sum_l =0, sum_r=0;
    for(int i=0,j=A.length-1;i<A.length;i++,j--) {

      sum_l += A[i];
      sum_r += A[j];

      left[i+1] = Math.max(left[i], sum_l);
      right[j] = Math.max(right[j+1], sum_r);

      if(i+1 >= L)
        sum_l -= A[i+1-L];
      if(i+1 >= M)
        sum_r  -= A[j+M-1];

    }

    for(int i=1;i<A.length;i++) {

      res = Math.max(res, left[i]+right[i]);
    }
    return res;

  }

  static class pair
  {
    int first, second;
    public pair(int first, int second)
    {
      this.first = first;
      this.second = second;
    }
  }

  public int maxSumTwoNoOverlap3aaaq(int[] A, int L, int R) {
        /*
        note that not overlap means index overlap, not value
        (can use prefix sum)
        solution: sliding windows 2 passes: l -> r then r -> l
        each pass: keep track of the main window and the max sub window
        ex: [0, 6, 5, 2, 9, 1], L = 1, R = 2
        start with index L + R
        -> [(0), (6, 5), 2, 9, 1] -> maxL = 0, R = 11 -> res = 11
        -> [0, (6), (5, 2), 9, 1] -> maxL = 6, R = 7  -> res = 13
        -> [0, 6, (5), (2, 9), 1] -> maxL = 6, R = 11 -> res = 17
        -> [0, 6, 5, (2), (9, 1)] -> maxL = 6, R = 10 -> res = 17 (17 > 16)
        -> first pass: 17
        second pass: go the opposite way or flip L & R;
        */
    return Math.max(maxSumLR(A, L, R), maxSumLR(A, R, L));
  }

  // helper funtion sliding window left to right
  private int maxSumLR(int[] A, int L, int R) {
    // start with L + R
    int i = 0;
    int sumL = 0, sumR = 0;
    // start with i = L + R
    while (i < L) sumL += A[i++];
    while (i < L + R) sumR += A[i++];
    int maxL = sumL, res = maxL + sumR;
    for (; i < A.length; i++) {
      // update the windows
      sumR += A[i] - A[i-R];
      sumL += A[i-R] - A[i - L - R];
      maxL = Math.max(maxL, sumL);
      res = Math.max(res, maxL + sumR);
    }
    return res;
  }







  // Utility method to get sum of subarray
// from index i to j
  static int getSubarraySum(int sum[],
      int i, int j)
  {
    if (i == 0)
      return sum[j];
    else
      return (sum[j] - sum[i - 1]);
  }

  // Method prints two non-overlapping subarrays of
// length K whose sum is maximum
  static void maximumSumTwoNonOverlappingSubarray(int arr[],
      int N, int K)
  {
    int []sum = new int[N];

    // filling prefix sum array
    sum[0] = arr[0];
    for (int i = 1; i < N; i++)
      sum[i] = sum[i - 1] + arr[i];

    // initializing subarrays from
    // (N-2K) and (N-K) indices
    pair resIndex = new pair(N - 2 * K, N - K);

    // initializing result sum from above subarray sums
    int maxSum2Subarray = getSubarraySum(sum, N - 2 * K,
        N - K - 1) +
        getSubarraySum(sum, N - K, N - 1);

    // storing second subarray maximum and
    // its starting index
    pair secondSubarrayMax = new pair(N - K,
        getSubarraySum(sum, N - K, N - 1));

    // looping from N-2K-1 towards 0
    for (int i = N - 2 * K - 1; i >= 0; i--)
    {
      // get subarray sum from (current index + K)
      int cur = getSubarraySum(sum, i + K, i + 2 * K - 1);

      // if (current index + K) sum is more
      // then update secondSubarrayMax
      if (cur >= secondSubarrayMax.second)
        secondSubarrayMax = new pair(i + K, cur);

      // now getting complete sum (sum of both subarrays)
      cur = getSubarraySum(sum, i, i + K - 1) +
          secondSubarrayMax.second;

      // if it is more then update main result
      if (cur >= maxSum2Subarray)
      {
        maxSum2Subarray = cur;
        resIndex = new pair(i, secondSubarrayMax.first);
      }
    }
    for (int i = resIndex.first;
        i < resIndex.first + K; i++)
      System.out.print(arr[i] + " ");
    System.out.println();

    for (int i = resIndex.second;
        i < resIndex.second + K; i++)
      System.out.print(arr[i] + " ");
    System.out.println();
  }

}
