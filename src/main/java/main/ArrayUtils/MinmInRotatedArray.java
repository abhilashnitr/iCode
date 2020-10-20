package main.ArrayUtils;

public class MinmInRotatedArray {

  public static void main (String[] args) {
    int[] nums={2,2,2,2,0,1};
    System.out.println(findMin(nums));
  }

  public static int findMin(int[] nums) {
    int l=0;
    int h=nums.length-1;

    while(l<=h){
      if(l+1==h||l==h)
        return Math.min(nums[l],nums[h]);
      int mid=(l+h)/2;
      if(nums[mid]<nums[h])
        h=mid;
      else if (nums[mid]>nums[h])
        l=mid;
      else            // equal conditions
        h--;
    }
    return -1;
  }

}
