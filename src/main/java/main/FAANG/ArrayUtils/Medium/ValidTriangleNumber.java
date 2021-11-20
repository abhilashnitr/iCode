package main.FAANG.ArrayUtils.Medium;

import java.util.Arrays;

//Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array
// that can make triangles if we take them as side lengths of a triangle.
//Input: [2,2,3,4]
//Output: 3
//Explanation:
//Valid combinations are:
//2,3,4 (using the first 2)
//2,3,4 (using the second 2)
//2,2,3
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int result = 0;
        if (nums.length < 3) return result;

        Arrays.sort(nums);

        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += (right - left);
                    right--;
                }
                else {
                    left++;
                }
            }
        }

        return result;
    }
}
