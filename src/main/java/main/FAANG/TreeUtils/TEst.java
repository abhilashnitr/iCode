package main.FAANG.TreeUtils;

import java.util.Arrays;

public class TEst {

  public static void main(String[] args) {
    System.out.println(titleToNumber("AB"));
  }

  public static int titleToNumber(String s) {
    int i=s.length()-1;
    int result=getInt(s.charAt(i--));
    while(i>=0){
      char c=s.charAt(i--);
      int fac=getInt(c);
      result = 26*fac + result;
    }
    return result;
  }



  private static int getInt(char c) {
    return (c - 'A'+1);
  }

  public static int[] singleNumber(int[] nums) {
    Arrays.sort(nums);
    int[] ans=new int[2];
    int k=0;
    for(int i = 0; i<nums.length-1; i+=2){
      if(nums[i] != nums[i+1])
      {
        ans[k++]=nums[i];
      }
    }
    if(k==1)
      ans[k++] = nums[nums.length-1];
    return ans;
  }

}
