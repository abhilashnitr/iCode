package main.FAANG.SlidingWindow;

//Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
// subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no
// such subarray, return 0 instead.
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] arr={2,3,1,2,4,3};
        int t=7;
        MinimumSizeSubarraySum minimumSizeSubarraySum=new MinimumSizeSubarraySum();
    }

    public int minSubArrayLen3(int target, int[] nums) {
        int curSum=0;
        int start=0;
        int res=Integer.MAX_VALUE;


        int end=0;

        while(end<nums.length){
            curSum+=nums[end];
            end++;
            while(curSum>=target){
                res=Math.min(res,end-start);
                curSum-=nums[start];
                start++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j++];

            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
    public int minSubArrayLen2c(int s, int[] A) {
        int i = 0, n = A.length, res = n + 1;
        for (int j = 0; j < n; ++j) {
            s -= A[j];
            while (s <= 0) {
                res = Math.min(res, j - i + 1);
                s += A[i++];
            }
        }
        return res % (n + 1);
    }
}
