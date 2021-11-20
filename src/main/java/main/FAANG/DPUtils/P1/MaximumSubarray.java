package main.FAANG.DPUtils.P1;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray m=new MaximumSubarray();
        System.out.println(m.maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        int curMax=0;
        int max=0;
        for(int a:nums){
            curMax=Math.max(a,a+curMax);
            max=Math.max(curMax,max);
        }
        return max;
    }
}
