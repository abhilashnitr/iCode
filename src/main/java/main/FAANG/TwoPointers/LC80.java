package main.FAANG.TwoPointers;

public class LC80 {
    public static void main(String[] args) {
        LC80 lc80=new LC80();
        int[] arr={1,1,1,2,2,3};
        int x=lc80.removeDuplicates(arr);
        for(int i=0;i<x;i++){
            System.out.print(arr[i]+" ");
        }

    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int id = 0;
        for (int i = 0; i < n; i++) {
            if (id<2 || nums[i] > nums[id - 2]) {
                nums[id++] = nums[i];
            }
        }
            return id;
        }


    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 2 && nums[i] == nums[i + 2]) {
                continue;
            }
            nums[j++] = nums[i];
        }
        return j;
    }
}
