package main.FAANG.StackUtils;

import java.util.Stack;

//Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
// Since the answer may be large, return the answer modulo 109 + 7.
public class SumofSubarrayMinimums {
    //Input: arr = [3,1,2,4]
    //Output: 17
    //Explanation:
    //Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
    //Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
    //Sum is 17.

   // https://leetcode.com/problems/sum-of-subarray-minimums/discuss/170750/JavaC%2B%2BPython-Stack-Solution

    public int sumSubarrayMins(int[] A) {
        long res = 0, mod = (int)1e9 + 7;
        int n = A.length, left[] = new int[n], right[] = new int[n];
        Stack<int[]> s1 = new Stack<>(), s2 = new Stack<>();
        for (int i = 0; i < n; ++i) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > A[i])
                count += s1.pop()[1];
            s1.push(new int[] {A[i], count});
            left[i] = count;
        }
        for (int i = n - 1; i >= 0; --i) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= A[i])
                count += s2.pop()[1];
            s2.push(new int[] {A[i], count});
            right[i] = count;
        }
        for (int i = 0; i < n; ++i)
            res = (res + (long)A[i] * left[i] * right[i]) % mod;
        return (int)res;
    }
}
