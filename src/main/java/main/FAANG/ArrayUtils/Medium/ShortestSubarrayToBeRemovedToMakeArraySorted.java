package main.FAANG.ArrayUtils.Medium;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {

    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, l = 0, r = n - 1;
        while(l + 1 < n && arr[l] <= arr[l + 1]) l++;  // find increasing subarray [0..l]
        if(l == n - 1) return 0;
        while(r - 1 >= 0 && arr[r - 1] <= arr[r]) r--; // find increasing subarray [r..n-1]
        int fr = 0, res = Math.min(n - l - 1, r);
        while (fr <= l && r < n) {  // find max combination
            while(fr <= l && arr[fr] <= arr[r]) fr++;
            res = Math.min(res, r - fr);  // remove [fr...r - 1];
            while(fr < n && r < n && arr[fr] > arr[r]) r++;
        }
        return res;
    }
}
