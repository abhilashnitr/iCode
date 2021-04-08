package main.FAANG.ArrayUtils;

import main.FAANG.TwoPointers.LC287;

//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
public class FindtheDuplicateNumber {

    public static void main(String[] args) {
        FindtheDuplicateNumber lc287=new FindtheDuplicateNumber();
        int[] arr={1,3,4,2,2,5,6,7,8,2};
        System.out.println(lc287.findDuplicate(arr));
    }
    int findDuplicate(int[] nums){
        for(int num:nums){
            int j=Math.abs(num);
            if(nums[j]<0)
                return Math.abs(j);
            nums[j]=-nums[j];
        }
        return -1;
    }

    int findDuplicate3(int[] nums)
    {
        if (nums.length> 1)
        {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}

