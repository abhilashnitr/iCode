package main.LeetCode.Easy.April27;

public class RemoveElement {

  public static void main(String[] args) {
    int[] nums={3,2,2,3};
    int y=removeElement(nums,3);
    for(int i=0;i<y;i++){
      System.out.print(nums[i]+" ");
    }
  }
  public static  int removeElement(int[] nums, int val) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != val) {
        nums[i] = nums[j];
        i++;
      }
    }
    return i;
  }

}
