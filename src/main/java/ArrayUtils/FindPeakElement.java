package ArrayUtils;

/*
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.
*/
public class FindPeakElement {

  public static void main (String[] args) {
    int[] x={1,2,1,3,5,6,7};

    FindPeakElement f=new FindPeakElement();
    int ans=f.findPeakElement(x);
    System.out.println(ans);
  }
  public int findPeakElement(int[] nums) {
    int low = 0;
    int high = nums.length -1;

    while(low < high)
    {
      int mid1 = (low+high)/2;
      int mid2 = mid1+1;
      if(nums[mid1] < nums[mid2])
        low = mid2;
      else
        high = mid1;
    }
    return low;
  }
}
