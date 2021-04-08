package main.FAANG.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that
// a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
//Notice that the solution set must not contain duplicate quadruplets.
//      Input: nums = [1,0,-1,0,-2,2], target = 0
//      Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
public class LC18 {

    int len = 0;

    public static void main(String[] args) {
        //-4,-1,1,2,3,4,6,9
        int[] arr={1,0,-1,0,-2,2};
        int target=0;
        LC18 lc18=new LC18();

        Arrays.sort(arr);
        System.out.println(lc18.fourSum(arr,0));

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }


    private ArrayList<List<Integer>> two_Sum(int[] nums, int target, int index){
        len = nums.length;
        int i = index, j = len - 1;
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        while(i < j) {
            //find a pair
            if(target - nums[i] == nums[j]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(target-nums[i]);
                res.add(temp);
                //skip duplication
                while(i<j && nums[i]==nums[i+1]) i++;
                while(i<j && nums[j-1]==nums[j]) j--;
                i++;
                j--;
                //move left bound
            } else if (target - nums[i] > nums[j]) {
                i++;
                //move right bound
            } else {
                j--;
            }
        }
        return res;
    }

    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(index >= len) {
            return res;
        }
        if(k == 2) {
            return two_Sum(nums,target,index);
        } else{
            for (int i = index; i < len - k + 1; i++) {
                //use current number to reduce ksum into k-1sum
                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
                if(temp != null){
                    //add previous results
                    for (List<Integer> t : temp) {
                        t.add(0, nums[i]);
                    }
                    res.addAll(temp);
                }
                while (i < len-1 && nums[i] == nums[i+1]) {
                    //skip duplicated numbers
                    i++;
                }
            }
        }
        return res;
    }
}
