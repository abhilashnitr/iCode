package LeetCode;

public class SearchInsertPosition {

  public int searchInsert(int[] nums, int target) {

    int i=0;
    while(i<nums.length){
      if(nums[i]<target)
      {
        i++;
      }
      else{
        break;
      }
    }
    return i;

  }

}
