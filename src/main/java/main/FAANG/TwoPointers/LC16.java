package main.FAANG.TwoPointers;

import java.util.Arrays;

public class LC16 {
    //Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
    //to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int result = num[0] + num[1] + num[num.length - 1];
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) { //duplocate check for i >0
                int lo = i+1, hi = num.length-1;
                int sum=0;
                while (lo < hi) {
                    sum = num[lo] + num[hi] + num[i];
                    if (sum < target) lo++;
                    else hi--;

                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                }
            }
        }
        return result;
    }
}
