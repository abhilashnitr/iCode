package main.FAANG.ArrayUtils;

import java.util.Arrays;

//Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with
// nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
//Input: nums = [34,23,1,24,75,33,54,8], k = 60
//Output: 58
//Explanation: We can use 34 and 24 to sum 58 which is less than 60.
public class TwoSumLessThanK {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A); // Time cost O(nlogn).
        int max = -1, i = 0, j = A.length - 1;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < K) { // find one candidate.
                max = Math.max(max, sum);
                ++i; // increase the smaller element.
            }else { // >= sum.
                --j; // decrease the bigger element.
            }
        }
        return max;
    }
}
