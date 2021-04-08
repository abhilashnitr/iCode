package main.FAANG.ArrayUtils;

import static main.ArrayUtils.SortArray012.swap;

//Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
//Input: [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
public class MaximumProductSubarray {

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = max(curr,max_so_far * curr,min_so_far * curr);
            min_so_far = max(curr,max_so_far * curr, min_so_far * curr);

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }

    public int max(int a,int b, int c){
        return Math.max(a,Math.max(b,c));
    }

    int maxProduct(int A[], int n) {
        // store the result that is the max we have found so far
        int r = A[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < n; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (A[i] < 0)
                swap(imax, imin);

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }
}
