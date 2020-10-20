package main.ArrayUtils;

import java.util.Arrays;

public class KDiffPairsInAnArray {

  public static void main(String[] args) {
    int[] x={1,3,1,5,4};
    int k=0;
    System.out.println(findPairs(x,k));

  }
  public int findPairsWithDup(int[] nums, int k) {
    Arrays.sort(nums);
    int i = 0, j = 1, count = 0;
    while(j < nums.length){
      if( i == j){
        j++;
      }
      if(j >= nums.length) break;
      while(i < j-1 && nums[i] == nums[i+1]) i++;
      while(j < nums.length -1 && nums[j] == nums[j+1]) j++;
      int dif = Math.abs(nums[i] - nums[j]);
      if(dif == k){
        count++; i++; j++;
      }
      else if(dif < k) j++;
      else i++;
    }
    return count;
  }

  public static int findPairs(int[] arr, int k) {

    int count = 0;
    Arrays.sort(arr); // Sort array elements
    int n=arr.length;
    int l = 0;
    int r = 1;
    while(r < n)
    {
      if(l==r)
        r++;
        else if(arr[r] - arr[l] == k)
      {
        count++;
        l++;
        r++;
      }
      else if(arr[r] - arr[l] > k)
        l++;
      else // arr[r] - arr[l] < sum
        r++;
    }
    return count;
  }

}
