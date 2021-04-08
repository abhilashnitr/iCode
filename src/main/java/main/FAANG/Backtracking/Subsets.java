package main.FAANG.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {


    //Given an integer array nums of unique elements, return all possible subsets (the power set).
    //
    //The solution set must not contain duplicate subsets. Return the solution in any order.
    //Input: nums = [1,2,3]
    //Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

//Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrackwithDup(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrackwithDup(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            if(i>start && nums[i]==nums[i-1])
                continue;
            tempList.add(nums[i]);
            backtrackwithDup(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
