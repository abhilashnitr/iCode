package main.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {

  public static void main (String[] args) {
    int[] x={1,1};
    System.out.println(findDuplicates(x));
  }
  public static List<Integer> findDuplicates(int[] nums) {
    List<Integer> ans=new ArrayList();
    for(int i=0;i<=nums.length-1;i++)
    {
      int x=Math.abs(nums[i])-1;
      if(nums[x]<0)
        ans.add(x+1);
      else
        nums[x]=-nums[x];
    }
    return ans;
  }
}
