package LeetCode.Easy.Array;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
* */
public class FindAllNumbersDisappearedInAnArray {

  public static void main(String[] args) {
    int[] nums={4,3,2,7,8,2,3,1};
    System.out.println(findDisappearedNumbers(nums));
  }
  public static List<Integer> findDisappearedNumbers(int[] nums) {
    int i, index, N = nums.length;
    for(i = 0; i < N; i++){

      index = Math.abs(nums[i]) - 1;
      nums[index] =0 -Math.abs(nums[index]); // mark as negative
    }

    List<Integer> list = new ArrayList<Integer>();
    for(i = 0; i < N; i++){
      if(nums[i] > 0){
        list.add(i + 1);
      }
    }
    return list;
  }
}
