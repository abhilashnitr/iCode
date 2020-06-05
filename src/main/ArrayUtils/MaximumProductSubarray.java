package main.ArrayUtils;
/*
Given an integer array nums,
find the contiguous subarray
within an array (containing
at least one number) which
has the largest product.
*/
//https://www.geeksforgeeks.org/maximum-product-subarray/#:~:text=The%20only%20thing%20to%20note,with%20%2D6%20and%20%2D2.
public class MaximumProductSubarray {


  public int maxProduct(int[] A) {
    if (A.length == 0) {
      return 0;
    }

    int maxherepre = A[0];
    int minherepre = A[0];
    int maxsofar = A[0];
    int maxhere, minhere;

    for (int i = 1; i < A.length; i++) {
      maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
      minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
      maxsofar = Math.max(maxhere, maxsofar);
      maxherepre = maxhere;
      minherepre = minhere;
    }
    return maxsofar;
  }
}
