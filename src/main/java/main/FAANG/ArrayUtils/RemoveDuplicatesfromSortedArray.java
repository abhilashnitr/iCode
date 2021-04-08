package main.FAANG.ArrayUtils;

public class RemoveDuplicatesfromSortedArray {
//Input: nums = [1,1,2]
//Output: 2, nums = [1,2]
//Explanation: Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
// It doesn't matter what you leave beyond the returned length.

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
