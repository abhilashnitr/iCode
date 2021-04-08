package main.FAANG.TwoPointers;

//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//Example:
//
//Input: [0,1,0,3,12]
//Output: [1,3,12,0,0]
public class LC283 {
    public void moveZeroes(int[] nums) {

        int j=0;
        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i])>0){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                j++;
            }
        }

    }
}
