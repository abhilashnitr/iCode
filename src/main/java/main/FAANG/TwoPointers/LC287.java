package main.FAANG.TwoPointers;
//Find the Duplicate Number
//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
//Input: nums = [1,3,4,2,2]
//Output: 2
//Input: nums = [3,1,3,4,2]
//Output: 3
public class LC287 {
    /*
    The main idea is the same with problem Linked List Cycle II,https://leetcode.com/problems/linked-list-cycle-ii/.
    Use two pointers the fast and the slow. The fast one goes forward two steps each time, while the slow one goes only
    step each time. They must meet the same item when slow==fast. In fact, they meet in a circle, the duplicate number
    must be the entry point of the circle when visiting the array from nums[0]. Next we just need to find the entry point.
    We use a point(we can use the fast one before) to visit form begining with one step each time, do the same job to slow.
    When fast==slow, they meet at the entry point of the circle. The easy understood code is as follows.
    */

    public static void main(String[] args) {
        LC287 lc287=new LC287();
        int[] arr={3,1,3,4,2};
        System.out.println(lc287.findDuplicate2(arr));
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

    public int findDuplicate(int[] nums) {


        //-1  3  4 -2  2
        // 0  1  2  3  4
        for(int i=0;i<nums.length;i++){
            int v=Math.abs(nums[i]);
            nums[v-1]= -nums[v];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                return i+1;
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {


        //-1  3  4 -2  2
        // 0  1  2  3  4
        for(int i=0;i<nums.length;i++){
            int v=Math.abs(nums[i]);
            nums[v-1]= -nums[v-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0)
                return i+1;
        }
        return -1;
    }
}
