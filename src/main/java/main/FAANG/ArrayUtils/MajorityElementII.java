package main.FAANG.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
public class MajorityElementII {

    //To figure out a O(1)O(1) space requirement, we would need to get this simple intuition first. For an array of length n:
    //
    //There can be at most one majority element which is more than ⌊n/2⌋ times.
    //There can be at most two majority elements which are more than ⌊n/3⌋ times.
    //There can be at most three majority elements which are more than ⌊n/4⌋ times.
        public List < Integer > majorityElement(int[] nums) {

            // 1st pass
            int count1 = 0;
            int count2 = 0;

            Integer candidate1 = null;
            Integer candidate2 = null;

            for (int n: nums) {
                if (candidate1 != null && candidate1 == n) {
                    count1++;
                } else if (candidate2 != null && candidate2 == n) {
                    count2++;
                } else if (count1 == 0) {
                    candidate1 = n;
                    count1++;
                } else if (count2 == 0) {
                    candidate2 = n;
                    count2++;
                } else {
                    count1--;
                    count2--;
                }
            }

            // 2nd pass
            List result = new ArrayList<>();

            count1 = 0;
            count2 = 0;

            for (int n: nums) {
                if (candidate1 != null && n == candidate1) count1++;
                if (candidate2 != null && n == candidate2) count2++;
            }

            int n = nums.length;
            if (count1 > n/3) result.add(candidate1);
            if (count2 > n/3) result.add(candidate2);

            return result;
        }

}
