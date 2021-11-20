package main.FAANG.ArrayUtils.Medium;

//Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//Follow up: Could you write an algorithm with O(log n) runtime complexity?
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
public class FindFirstandLastPositionofElementinSortedArray {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,5,5,5,6};
        int[] ans=searchRange(arr,5);
        System.out.println(ans[0]+"  "+ans[1]);

    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private static int findFirst(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private static int findLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
}
