package main.ArrayUtils;

public class RemoveDuplicatesFromSortedArrayMoreThan2Occ {

  public static void main (String[] args) {
    int[] x={1,1,1,1,2,2,2,2,3,3,4,4,5,5,6};
    int y=removeDuplicates(x);
    for(int i=0;i<y;i++){
      System.out.print(x[i]+" ");
    }
  }
  private static int removeDuplicates(int[] nums) {
    int n = nums.length;
    int j = 0;
    for (int i = 0; i < n; i++) {
      if (i < n - 2 && nums[i] == nums[i + 2]) {
      continue;
    }
      nums[j++] = nums[i];
    }
    return j;
  }

}
