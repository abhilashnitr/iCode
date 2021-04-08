package main.FAANG.TwoPointers;

//You may recall that an array arr is a mountain array if and only if:
//
//arr.length >= 3
//There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.
//Input: arr = [2,1,4,7,3,2,5]
//Output: 5
//Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
public class LC845 {

    public int longestMountain(int[] arr) {
        int max = 0;

        for(int i = 1; i < arr.length-1; i++) {
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {  // peak of moutain
                int left = i-1;
                int right = i+1;

                while(left > 0 && arr[left-1] < arr[left]) left--;
                while(right < arr.length-1 && arr[right] > arr[right+1]) right++;

                max = Math.max(max, right-left+1);
            }
        }

        return max;
    }
}
