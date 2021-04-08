package main.FAANG.DPUtils.P2;

import java.util.HashMap;
import java.util.Map;

//Input: nums is [1, 1, 1, 1, 1], S is 3.
//Output: 5
//Explanation:
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
public class TargetSum {

    public static void main(String[] args) {
        TargetSum targetSum=new TargetSum();
        int[] arr={1, 1, 1, 1, 1};
        System.out.println(targetSum.findTargetSumWays(arr,3));
    }
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        return helper(nums, 0, 0, S);
    }
    private int helper(int[] nums, int index, int sum, int S){

        if (index == nums.length){
            if (sum == S){
                return 1;
            }else {
                return 0;
            }
        }
        int curNum = nums[index];
        int add = helper(nums, index + 1, sum - curNum, S);
        int minus = helper(nums, index + 1, sum + curNum, S);
        return add + minus;
    }

    public int findTargetSumWaysWithMemo(int[] nums, int S) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        return helper(nums, 0, 0, S, new HashMap<>());
    }
    private int helper(int[] nums, int index, int sum, int S, Map<String, Integer> map){
        String encodeString = index + "->" + sum;
        if (map.containsKey(encodeString)){
            return map.get(encodeString);
        }
        if (index == nums.length){
            if (sum == S){
                return 1;
            }else {
                return 0;
            }
        }
        int curNum = nums[index];
        int add = helper(nums, index + 1, sum - curNum, S, map);
        int minus = helper(nums, index + 1, sum + curNum, S, map);
        map.put(encodeString, add + minus);
        return add + minus;
    }
}
