package main.FAANG.ArrayUtils;

public class MoveZeros {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }


    public void moveZeroes2(int[] nums) {

        int j=0;
        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i])>0){
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                j++;
            }
        }

    }

}
