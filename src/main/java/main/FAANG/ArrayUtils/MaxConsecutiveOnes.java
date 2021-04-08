package main.FAANG.ArrayUtils;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes=new MaxConsecutiveOnes();
        int[] arr={1,0,1,1,0,1};
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(arr));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums) {
            maxHere = n == 0 ? 0 : maxHere + 1;
            max = Math.max(max, maxHere);
        }
        return max;
    }
}
