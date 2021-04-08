package main.FAANG.TwoPointers;

import java.util.HashMap;
import java.util.Map;

//532. K-diff Pairs in an Array
//Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
//
//A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
//
//0 <= i, j < nums.length
//i != j
//|nums[i] - nums[j]| == k
//Notice that |val| denotes the absolute value of val.
public class LC352 {

    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)   return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                //count how many elements in the array that appear more than twice.
                if (entry.getValue() > 1) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }

        return count;
    }
}
