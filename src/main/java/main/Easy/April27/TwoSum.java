package main.LeetCode.Easy.April27;

import java.util.HashMap;

public class TwoSum {

  public int[] twoSum(int[] nums, int target,int low,int high) {
    HashMap<Integer,Integer> map= new HashMap();
    map.put(nums[low],low);
    int[] res=new int[2];
    for(int i=low+1;i<high;i++){
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
