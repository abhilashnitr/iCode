package main.FAANG.ArrayUtils.NotTried;

import java.util.Arrays;
import java.util.stream.IntStream;

//You are given two arrays of integers nums1 and nums2, possibly of different lengths. The values in the arrays are between 1 and 6, inclusive.
//
//In one operation, you can change any integer's value in any of the arrays to any value between 1 and 6, inclusive.
//
//Return the minimum number of operations required to make the sum of values in nums1 equal to the sum of values in nums2. Return -1 if it is not possible to make the sum of the two arrays equal.
//Input: nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//Output: 3
//Explanation: You can make the sums of nums1 and nums2 equal with 3 operations. All indices are 0-indexed.
//- Change nums2[0] to 6. nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2].
//- Change nums1[5] to 1. nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2].
//- Change nums1[2] to 2. nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2].
public class EqualSumArraysWithMinimumNumberofOperations {

    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6};
        int[] arr2={1,1,2,2,6,6};

        EqualSumArraysWithMinimumNumberofOperations main=new EqualSumArraysWithMinimumNumberofOperations();

        System.out.println(main.minOperations(arr1,arr2));
    }
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums1.length > 6 * nums2.length) {
            return -1;
        }
        int sum1 = IntStream.of(nums1).sum();
        int sum2 = IntStream.of(nums2).sum();
        if (sum1 > sum2) {
            return minOperations(nums2, nums1); // make sure the sum of 1st array <= sum of 2nd one.
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = nums2.length - 1, operations = 0;
        while (sum2 > sum1) {
            // increase the number in nums1 or decrease the number in nums2?
            if (j < 0 || i < nums1.length && 6 - nums1[i] > nums2[j] - 1) {
                sum1 += 6 - nums1[i++]; // increase to 6 the number in nums1.
            }else {
                sum2 -= nums2[j--] - 1; // decrease to 1 the number in nums2.
            }
            ++operations;
        }
        return operations;
    }
}
