package LeetCode.Easy.Array;

public class ThirdMax {

  public int thirdMax(int[] nums) {
    long max = Long.MIN_VALUE,
        secondMax = Long.MIN_VALUE,
        thirdMax = Long.MIN_VALUE;
    for (int num : nums) {
      if (num > max) {
        thirdMax = secondMax;
        secondMax = max;
        max = num;
      } else if (num < max && num > secondMax) {
        thirdMax = secondMax;
        secondMax = num;
      } else if (num < max && num < secondMax && num > thirdMax) {
        thirdMax = num;
      }
    }
    return thirdMax > Long.MIN_VALUE ? (int) thirdMax : (int) max;
  }

}
