package main.FAANG.ArrayUtils;

import java.util.HashSet;
import java.util.Set;

//Given an array of integers, find if the array contains any duplicates.
//Your function should return true if any value appears at least twice in the array, and it should return false if every
// element is distinct.
//Input: [1,2,3,1]
// Output: true
public class ContainsDuplicate {
    public  boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums)
            if(!set.add(i))// if there is same
                return true;
        return false;
    }
}
