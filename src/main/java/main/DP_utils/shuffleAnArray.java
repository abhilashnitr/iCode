package main.DP_utils;

import java.util.Random;

public class shuffleAnArray {
  int[] nums;
  int[] orig;
  Random rand = new Random();

  public shuffleAnArray(int[] nums) {
    this.nums = nums;
    this.orig = nums.clone();
  }
  public int[] shuffle() {
    int i = 0;
    while(i < nums.length){
      int newPos = rand.nextInt(nums.length);

      int temp = nums[i];
      nums[i] = nums[newPos];
      nums[newPos] = temp;

      i++;
    }

    return nums;
  }

}
