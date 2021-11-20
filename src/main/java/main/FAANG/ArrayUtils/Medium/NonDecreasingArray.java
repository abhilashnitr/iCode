package main.FAANG.ArrayUtils.Medium;
//Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one
// element.
//
//We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
//Input: nums = [4,2,3]
//Output: true
//Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
public class NonDecreasingArray {
    //The strategy is to lower a[i-1] to match a[i] if possible - (a[i-2] not exist or no smaller than a[i]);
    //otherwise rise a[i] to match a[i-1].
    //
    //2 Examples:
    // 0  ...  i ...
    // 1 1 2 4[2]5 6  - in this case we can just raise a[i] to 4;
    //         4
    // 1 1 2[4]2 3 4  - in this case lower a[i-1] is better;
    //       2


    public static void main(String[] args) {
        int[] arr={3,4,2,3};
        System.out.println(checkPossibility(arr));
    }
    public static boolean checkPossibility(int[] a) {
        int modified = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                if (modified++ > 0) return false;
                if (i - 2 < 0 || a[i - 2] <= a[i]) a[i - 1] = a[i]; // lower a[i - 1]
                else a[i] = a[i - 1]; // rise a[i]
            }
        }
        return true;
    }
    //We can also do it without modifying the input by using a variable prev to hold the a[i-1]; if we have to lower
    // a[i] to match a[i-1] instead of raising a[i-1], simply skip updating prev;

    public boolean checkPossibility2(int[] a) {
        int modified = 0;
        for (int i = 1, prev = a[0]; i < a.length; i++) {
            if (a[i] < prev) {
                if (modified++ > 0) return false;
                if (i - 2 >= 0 && a[i - 2] > a[i]) continue;
            }
            prev = a[i];
        }
        return true;
    }


    //https://leetcode.com/problems/non-decreasing-array/discuss/106849/C%2B%2B-Java-Clean-Code-6-liner-Without-Modifying-Input
}
