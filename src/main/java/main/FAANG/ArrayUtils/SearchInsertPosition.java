package main.FAANG.ArrayUtils;

//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
// the index where it would be if it were inserted in order.
//Input: nums = [1,3,5,6], target = 5
//Output: 2
public class SearchInsertPosition {

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition=new SearchInsertPosition();
        int[] arr={1,3,5,6};
        System.out.println(searchInsertPosition.searchInsert(arr,7));
    }

    public int searchInsert(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left + (right - left) / 2;
            if(nums[mid]==target)
                return mid;
            if(nums[mid]>target)
                right=mid-1;
            else
                left=mid+1;
        }
        return left;

    }
}
