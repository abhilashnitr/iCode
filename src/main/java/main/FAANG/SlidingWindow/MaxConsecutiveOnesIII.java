package main.FAANG.SlidingWindow;
/*
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s.
Question is same as Find the longest subarray with at most K zeros.
For each A[j], try to find the longest subarray.
If A[i] ~ A[j] has zeros <= K, we continue to increment j.
If A[i] ~ A[j] has zeros > K, we increment i (as well as j).
*/

public class MaxConsecutiveOnesIII {

    //340. Longest Substring with At Most K Distinct Characters
    public static void main(String[] args) {
        int[] a={1,1,1,0,0,0,1,1,1,1,0};
        MaxConsecutiveOnesIII m= new MaxConsecutiveOnesIII();
        System.out.println(m.longestOnes2(a,2));
    }

    public int longestOnes(int[] A, int K) {
        int zeroCount=0,start=0,res=0;
        for(int end=0;end<A.length;end++){
            if(A[end] == 0) zeroCount++;
            while(zeroCount > K){
                if(A[start] == 0) zeroCount--;
                start++;
            }
            res=Math.max(res,end-start+1);
        }
        return res;
    }

    //For each A[j], try to find the longest subarray.
    //If A[i] ~ A[j] has zeros <= K, we continue to increment j.
    //If A[i] ~ A[j] has zeros > K, we increment i (as well as j).
    public int longestOnes2(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }
}
