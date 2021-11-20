package main.FAANG.ArrayUtils.Medium;
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
//
//Find the minimum element.
//
//The array may contain duplicates.
public class FindMinimuminRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int i=0;
        int j=nums.length-1;

        while(i<=j){

            //handle cases like [3, 1, 3]
            while(nums[i]==nums[j] && i!=j){
                i++;
            }

            if(nums[i]<=nums[j]){
                return nums[i];
            }

            int m=(i+j)/2;
            if(nums[m]>=nums[i]){
                i=m+1;
            }else{
                j=m;
            }
        }

        return -1;
    }

    public int findMin2(int[] nums) {
        int left =0; int right = nums.length - 1;
        while (left < right) {
            while(nums[left]==nums[right] && left!=right){
                left++;
            }
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            }
            else
            {
                right = mid;
            }
        }
        // terminates when left = right
        return nums[left];
    }


    public int findMinWithRec(int[] num) {
        return findMin(num, 0, num.length-1);
    }

    public int findMin(int[] num, int left, int right){
        if(right==left){
            return num[left];
        }
        if(right == left +1){
            return Math.min(num[left], num[right]);
        }
        // 3 3 1 3 3 3

        int middle = (right-left)/2 + left;
        // already sorted
        if(num[right] > num[left]){
            return num[left];
            //right shift one
        }else if(num[right] == num[left]){
            return findMin(num, left+1, right);
            //go right
        }else if(num[middle] >= num[left]){
            return findMin(num, middle, right);
            //go left
        }else{
            return findMin(num, left, middle);
        }
    }
}
