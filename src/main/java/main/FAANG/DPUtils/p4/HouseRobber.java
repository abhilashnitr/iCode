package main.FAANG.DPUtils.p4;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums={2,1,1};
        HouseRobber hr=new HouseRobber();
        System.out.println(hr.rob(nums));
    }

    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0)
            return 0;
        if(n==1)
            return nums[0];
        return robHelper(nums,0,nums.length);
    }

    private int robHelper(int[] nums, int start, int end) {
        int exclude=0;
        int include=nums[start];
        for(int i=start+1;i<end;i++){
            int include_new=exclude+nums[i];
            exclude=Math.max(include,exclude);
            include=include_new;
        }
        return Math.max(exclude,include);
    }


}
