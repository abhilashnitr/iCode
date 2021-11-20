package main.FAANG.DPUtils.P2;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationsToReduceXtoZero {


    public static void main(String[] args) {

    }
    int minOperation(int[] nums,int x){
        int target = -x;
        for (int num : nums) target += num;

        if (target == 0) return nums.length;  // since all elements are positive, we have to take all of them

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; ++i) {

            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }

            // no need to check containsKey since sum is unique
            map.put(sum, i);
        }

        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }


    Map<String,Integer> mem;
    int solve(int[] nums,int x,int left,int right,int count)
    {
        if(x==0)    //Sum found
            return count;
        if(x<0 || left>right)   //Out of bounds
        return Integer.MAX_VALUE;
        String key = left+"*"+right+"*"+x; //Form Key
        if(mem.containsKey(key))  //Check if already calculated
            return mem.get(key);

        int l = solve(nums,x-nums[left],left+1,right,count+1);  //Include left element
        int r = solve(nums,x-nums[right],left,right-1,count+1); //Include right element
         mem.put(key,Math.min(l,r));
        return  mem.get(key);
    }
    int minOperationsDp(int[] nums, int x) {
        int ans = solve(nums,x,0,nums.length-1,0);
        return ans>=1e6?-1:ans;
    }
}
