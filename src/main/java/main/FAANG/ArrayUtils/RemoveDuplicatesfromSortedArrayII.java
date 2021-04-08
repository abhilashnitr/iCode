package main.FAANG.ArrayUtils;

public class RemoveDuplicatesfromSortedArrayII {

    public int removeDuplicates(int[] nums) {
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
