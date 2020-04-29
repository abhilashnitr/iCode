package LeetCode;

public class RemoveDuplicatesfromSortedArray {

  public static void main(String[] args) {
    int[] nums={1,2};
  }

  public int removeDuplicates(int[] nums) {

    if(nums.length==0||nums.length==1)
      return nums.length;

    int k=0;
    int i=0;
    for(i=0;i<nums.length-1;i++){
      if(nums[i]!=nums[i+1]){
        nums[k]=nums[i];
        k++;
      }
    }
    nums[k]=nums[i];
    return k+1;
  }

}
