package main.FAANG.DPUtils.p4;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = max(curr,max_so_far * curr,min_so_far * curr);
            min_so_far = min(curr,max_so_far * curr, min_so_far * curr);

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }

    public int max(int a,int b, int c){
        return Math.max(a,Math.max(b,c));
    }

    public int min(int a,int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
