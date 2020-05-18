package ArrayUtils;

public class SearchinRotatedSortedArray {

  public static void main(String[] args) {
    int[] x={4,5,5,5,6,7,0,0,1,1,1,1,1,1,1,1,2};
    System.out.println(searchIterative(x,6));
  }
  public static int searchIterative(int[] nums, int target) {
    int start = 0;
    int end = nums.length-1;

    while(start<=end){

      int mid = start+(end-start)/2;

      if(nums[mid] == target)
        return mid;

      // Check ont the left Side
      if(nums[start] <= nums[mid]){
        if(target >= nums[start] && target <= nums[mid])
          end = mid-1;
        else
          start =mid+1;
      }
      // Check ont the Right Side
      else if(nums[mid] <= nums[end]){
        if(target>=nums[mid] && target<= nums[end])
          start = mid+1;
        else
          end =mid-1;
      }

    }
    return -1;
  }


  public static boolean search(int[] nums, int target) {

    if(nums.length == 0)
      return false;

    int low = 0;
    int high = nums.length - 1;
    if (nums[low] == target)
      return true;

    while (low < nums.length && nums[low] == nums[high]) {
      low++;
    }

    return search(nums, target, low, high);
  }

  public static boolean search(int[] nums, int target, int low, int high) {

    if (low > high)
      return false;

    int mid = low + (high - low) / 2;
    if (nums[mid] == target)
      return true;
    if (nums[low] <= nums[mid]) {
      if (target >= nums[low] && target < nums[mid])
        return search(nums, target, low, mid - 1);
      return search(nums, target, mid + 1, high);
    } else {
      if (target > nums[mid] && target <= nums[high])
        return search(nums, target, mid + 1, high);
      return search(nums, target, low, mid - 1);
    }
  }

}
