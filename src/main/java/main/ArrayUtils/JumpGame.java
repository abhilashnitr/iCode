package main.ArrayUtils;

import java.util.Arrays;

public class JumpGame {

  public static void main(String[] args) {
    int[] x={2,0,1,0,3,0,0,1};

    System.out.println(canJump2(x));
  }
  public static boolean canJump(int[] nums) {
    if(nums.length <=1) return true;

    int lastZero=-1;

    for(int i=nums.length-1;i>=0;i--){
      if(nums[i]==0 && lastZero==-1){
        lastZero=i;
      } else if(lastZero>-1){
        if(nums[i]+i>lastZero || nums[i]+i==nums.length-1)
          lastZero=-1;
      }
    }

    return lastZero==-1;

  }

  public static boolean canJump2(int[] nums) {
    int lastKnownPosition = nums.length - 1;
    for(int i = nums.length - 2; i >= 0; i--){
      if(i + nums[i] >= lastKnownPosition){
        lastKnownPosition = i;
      }
    }
    return lastKnownPosition == 0;
  }

  public int jumpDp(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;

    for (int start = 0; start < nums.length; start++){
      for (int end = start + 1; end < nums.length && end <= start+nums[start]; end++){
        dp[end] = Math.min(dp[end], dp[start]+1);
      }
    }
    return dp[dp.length-1];
  }
  public int jumpGreedy1(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;

    int lastReach = 0;
    int reach = 0;
    int step = 0;

    for (int i = 0; i <= reach && i < nums.length; i++) {
      //when last jump can not read current i, increase the step by 1
      if (i > lastReach) {
        step++;
        lastReach = reach;
      }
      //update the maximal jump
      reach = Math.max(reach, nums[i] + i);
    }

    if (reach < nums.length - 1)
      return 0;

    return step;
  }

  public int jumpGreedy2(int[] nums){

    int position = nums[0]; //maximum index travelled from input index = 1;
    int max_pos_for_each_i=nums[0];
    int jumps=1;
    for(int i=1;i<nums.length;i++){
      if(position<i) //check if the steps are exhusted or over
      {
        jumps++;
        position = max_pos_for_each_i;
      }
      max_pos_for_each_i = Math.max(max_pos_for_each_i,nums[i]+1);
    }
    return jumps;
  }

}
