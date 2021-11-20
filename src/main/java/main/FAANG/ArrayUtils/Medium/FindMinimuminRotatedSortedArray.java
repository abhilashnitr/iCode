package main.FAANG.ArrayUtils.Medium;

public class FindMinimuminRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        FindMinimuminRotatedSortedArray findMinimuminRotatedSortedArray=new FindMinimuminRotatedSortedArray();
        System.out.println(findMinimuminRotatedSortedArray.findMin(arr));
    }

    public int findMin(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;

        int i=0;
        int j=nums.length-1;

        while(i<=j){
            if(nums[i]<=nums[j])
                return nums[i];

            int m=(i+j)/2;
            //left array is sorted so min is in right
            if(nums[m]>=nums[i]){
                i=m+1;
            }else{
                //else left side
                j=m;
            }
        }

        return -1;
    }


    public static int findMin2(int[] nums) {
        int left =0; int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid+1;
            } else { right = mid;}
        }
        // terminates when left = right
        return nums[left];
    }
}
