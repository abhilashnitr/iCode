package main.FAANG.TwoPointers;

import java.util.Arrays;

//Two Sum Less Than K
//Given an array nums of integers and integer k, return the maximum sum such that there exists i < j with nums[i] + nums[j] = sum and sum < k. If no i, j exist satisfying this equation, return -1.
//Input: nums = [34,23,1,24,75,33,54,8], k = 60
//Output: 58
//Explanation: We can use 34 and 24 to sum 58 which is less than 60.
public class LC1099 {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int answer = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                answer = Math.max(answer, sum);
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}
