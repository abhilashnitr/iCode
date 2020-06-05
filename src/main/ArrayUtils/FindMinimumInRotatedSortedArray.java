package main.ArrayUtils;

public class FindMinimumInRotatedSortedArray {

  public static void main(String[] args) {
    int[] x={7,1,1,2,4,5,6,7};
    System.out.println(findMin(x));
  }

  public static int findMin(int[] nums) {
    int left =0; int right = nums.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] > nums[right]) {
        left = mid+1;
      } else { right = mid;}
    }
    // terminates when left = right
    return nums[left];
  }

}
