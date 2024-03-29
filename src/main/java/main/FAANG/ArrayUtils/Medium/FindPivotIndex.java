package main.FAANG.ArrayUtils.Medium;

public class FindPivotIndex {
    //Given an array of integers nums, calculate the pivot index of this array.
    //
    //The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the
    // sum of all the numbers strictly to the index's right.
    //
    //If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
    // This also applies to the right edge of the array.
    //
    //Return the leftmost pivot index. If no such index exists, return -1.

    //Input: nums = [1,7,3,6,5,6]
    //Output: 3
    //Explanation:
    //The pivot index is 3.
    //Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
    //Right sum = nums[4] + nums[5] = 5 + 6 = 11

    public static void main(String[] args) {
        int[] arr={2,1,-1};
        FindPivotIndex findPivotIndex=new FindPivotIndex();
        System.out.println(findPivotIndex.pivotIndex(arr));
    }

    public int pivotIndex2(int[] nums) {
        int sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) left += nums[i - 1];
            if (sum - left - nums[i] == left) return i;
        }

        return -1;
    }

    public int pivotIndex(int[] nums) {
        int total = 0, sum = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < nums.length;i++ ){
            if(i>0)sum += nums[i-1];
            if (sum * 2 == total - nums[i]) return i;
        }
        return -1;
    }
}
