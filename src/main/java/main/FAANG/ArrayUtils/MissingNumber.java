package main.FAANG.ArrayUtils;

//Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is
// missing from the array.
public class MissingNumber {

    //a^a^b=b
    public int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={9,6,4,2,3,5,7,0,1};
        MissingNumber missingNumber=new MissingNumber();
        System.out.println(missingNumber.missingNumber3(arr));
    }

    public int missingNumber3(int[] nums) {

        int mask=nums.length+1;
        for(int i=0;i<nums.length;i++){
            int idx=nums[i];
            if(idx==nums.length)
                continue;
            else
            {
                if(nums[i]>=mask)
                    idx=nums[i]-mask;
                nums[idx]=mask+nums[idx];
            }
        }
        int res=nums.length;
        for(int i=0;i<nums.length;i++)
            if(nums[i]<mask)
                res=i;
        return res;
    }

    public int missingNumber2(int[] nums) { //sum
        int len = nums.length;
        int sum = (0+len)*(len+1)/2;
        for(int i=0; i<len; i++)
            sum-=nums[i];
        return sum;
    }
}

























