package main.FAANG.ArrayUtils;

//Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Determine if you are able to reach the last index.
//Input: nums = [2,3,1,1,4]
//Output: true
//Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

//there is a dynamic programming solution
public class JumpGame {

    public static void main(String[] args) {
        JumpGame jumpGame=new JumpGame();
        int[] arr={2,3,1,1,4};
        System.out.println(jumpGame.canJump3(arr));
    }

    boolean canJump(int A[]) {
        int n=A.length;
        int last=n-1,i,j;
        for(i=n-2;i>=0;i--){
            if(i+A[i]>=last)last=i;
        }
        return last<=0;
    }

    public boolean canJump2(int[] nums) {
        int maxLocation = 0;
        for(int i=0; i<nums.length; i++) {
            if(maxLocation<i) return false; // if previous maxLocation smaller than i, meaning we cannot reach location i, thus return false.
            maxLocation = (i+nums[i]) > maxLocation ? i+nums[i] : maxLocation; // greedy:
        }
        return true;
    }

    //dp
    boolean canJump3(int[] nums) {
        int n = nums.length;
        boolean[] jump=new boolean[nums.length];
        jump[n-1]=true;

        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<=nums[i] && i+j<n;j++)
            {
                if(jump[i+j]==true)
                {
                    jump[i]=true;
                    break;
                }
            }
        }

        return jump[0];
    }
}
