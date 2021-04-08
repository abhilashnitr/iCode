package main.FAANG.ArrayUtils;

// A peak element is an element that is strictly greater than its neighbors.
// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.
// Input: nums = [1,2,1,3,5,6,4]
// Output: 5
// Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the
// peak element is 6.
public class FindPeakElement {
    public static int findPeakElement(int[] A, int left, int right)
    {
        // find the middle element. To avoid overflow, use `left + (right - left) / 2`
        int mid = (left + right) / 2;

        // check if the middle element is greater than its neighbors
        if ((mid == 0 || A[mid - 1] <= A[mid]) &&
                (mid == A.length - 1 || A[mid + 1] <= A[mid])) {
            return mid;
        }

        // If the left neighbor of `mid` is greater than the middle element,
        // find the peak recursively in the left subarray
        if (mid - 1 >= 0 && A[mid - 1] > A[mid]) {
            return findPeakElement(A, left, mid - 1);
        }

        // If the right neighbor of `mid` is greater than the middle element,
        // find the peak recursively in the right subarray
        return findPeakElement(A, mid + 1, right);
    }

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    //https://leetcode.com/problems/find-peak-element/discuss/50232/Find-the-maximum-by-binary-search-(recursion-and-iteration)
}
