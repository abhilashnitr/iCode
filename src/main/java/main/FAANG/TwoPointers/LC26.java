package main.FAANG.TwoPointers;
//Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
//
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
public class LC26 {

    public int removeDuplicates(int[] nums) {

        if(nums.length==0||nums.length==1)
            return nums.length;
        int k=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[k]){
                k++;
                nums[k]=nums[i];
            }

        }
        return k+1;

    }
}
