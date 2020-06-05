package main.ArrayUtils;

public class FirstAndLastPositionOfElementInSortedArray {

  public static void main(String[] args) {
    int[] x={1};
    int[] ans=findFirstAndlast(x,1);
    System.out.println(ans[0]+" "+ans[1]);
  }

  private static int[] findFirstAndlast(int[] nums,int target) {

      if(nums==null || nums.length<=0)
        return new int[]{-1,-1};

      int low =0;
      int high =nums.length-1;

      while(low < high)
      {
        int mid = low + (high-low)/2;

        if(nums[mid] == target )
        {
          low = high = mid;
          while(low >0 && nums[low-1]==target)
          {
            low--;
          }
          while(high <nums.length-1 && nums[high+1] == target)
          {
            high++;
          }
          break;
        }
        else if(nums[mid] < target)
        {
          low = mid+1;
        }
        else
        {
          high = mid-1;
        }

      }

      return (nums[low]  == target && nums[high]  == target) ? new int[]{low,high} : new int[]{-1,-1};


    }



}
