package ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/*
Given a sorted integer array without duplicates, return the summary of its ranges.

    Example 1:

    Input:  [0,1,2,4,5,7]
    Output: ["0->2","4->5","7"]
    Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
*/
public class SummaryRanges {
  public List<String> summaryRanges(int[] nums) {
    List<String> list=new ArrayList();
    if(nums.length==1){
      list.add(nums[0]+"");
      return list;
    }
    for(int i=0;i<nums.length;i++){
      int a=nums[i];
      while(i+1<nums.length&&(nums[i+1]-nums[i])==1){
        i++;
      }
      if(a!=nums[i]){
        list.add(a+"->"+nums[i]);
      }else{
        list.add(a+"");
      }
    }
    return list;
  }
}
