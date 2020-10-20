package main.LeetCode.Easy.April27;

import java.util.HashMap;

public class TwoSum {

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> map= new HashMap();
    map.put(nums[0],0);
    int[] res=new int[2];
    for(int i=1;i<nums.length;i++){
      if(map.containsKey(target-nums[i])){
        res[0]=map.get(target-nums[i]);
        res[1]=i;
        return res;
      }
      map.put(nums[i],i);
    }
    return res;

  }

}
