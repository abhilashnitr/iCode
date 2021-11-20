package main.FAANG.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        CombinationSum combinationSum=new CombinationSum();
        int[] nums={1,2,3};
        int sum=4;
        System.out.println(combinationSum.combinationSum(nums,sum));
//        System.out.println(combinationSum.combinationSum4(nums,sum));
//        System.out.println(combinationSum.combinationSum4Memo(nums,sum));
//        System.out.println(combinationSum.combinationSum4Rec(nums,sum));

    }

    //Input: candidates = [2,3,6,7], target = 7
    //Output: [[2,2,3],[7]]
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        if(remain == 0) list.add(new ArrayList<>(tempList));

        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> result= new ArrayList<>();
        List<List<Integer>> resultList= new ArrayList<>();
        backtrack(candidates,target,result,resultList,0);
        return resultList;
    }

    public void backtrack(int[] arr, int sum, List<Integer> result, List<List<Integer>> resultList, int startindex) {
        if(sum==0){
            if(!resultList.contains(result))
                resultList.add(new ArrayList<>(result));
        }
        if(startindex==arr.length)
            return;
        for(int i=startindex;i<arr.length;i++){
            if(arr[i]>sum)
                continue;
            result.add(arr[i]);
            backtrack(arr,sum-arr[i],result,resultList,i+1);
            result.remove(result.size()-1);
        }

    }


    //Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    //
    //Only numbers 1 through 9 are used.
    //Each number is used at most once.
    //Return a list of all possible valid combinations. The list must not contain the same combination twice,
    // and the combinations may be returned in any order.

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int sum) {
        if (comb.size() == k && sum == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            backtrack(ans, comb, k, i+1, sum-i);
            comb.remove(comb.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3V2(int k, int n) {
        int[] num = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), num, k, n,0);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> list, int[] num, int k, int target, int start){
        if (k == 0 && target == 0){
            result.add(new ArrayList<Integer>(list));
        } else {
            for (int i = start; i < num.length && target > 0 && k >0; i++){
                list.add(num[i]);
                helper(result, list, num, k-1,target-num[i],i+1);
                list.remove(list.size()-1);
            }
        }
    }
//Input: nums = [1,2,3], target = 4
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//Note that different sequences are counted as different combinations.

    public int combinationSum4Rec(int[] nums, int target) {
        return answerRec(nums,target);
    }
    public static int answerRec(int[] arr,int target){
        if(target==0){
            return 1;
        }
        if(target<0) return 0;


        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans+=answerRec(arr,target-arr[i]);  // taking all elements of array into account
        }
        return ans;
    }


    public int combinationSum4Memo(int[] nums, int target) {
        int[] memo = new int[target+1];
        Arrays.fill(memo,-1);
        return answer(nums,target,memo);
    }
    public static int answer(int[] arr,int target,int[] memo){
        if(target==0){
            return 1;
        }
        if(target<0) return 0;

        if(memo[target]!=-1) return memo[target]; //memoization

        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans+=answer(arr,target-arr[i],memo);  // taking all elements of array into account
        }
        return memo[target]=ans;
    }

    //Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
    //Input: nums = [1,2,3], target = 4
    //Output: 7
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return backtrack(nums, target);
    }

    private int backtrack(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += backtrack(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }

    public int combinationSum4Dp(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }

}

