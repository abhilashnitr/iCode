package main.FAANG.DPUtils.p4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthofLongestFibonacciSubsequence {

    public int lenLongestFibSubseq(int[] A) {
        Set<Integer> s = new HashSet<Integer>();
        for (int x : A) s.add(x);
        int res = 2;
        for (int i = 0; i < A.length; ++i)
            for (int j = i + 1; j < A.length; ++j) {
                int a = A[i], b = A[j], l = 2;
                while (s.contains(a + b)) {
                    b = a + b;
                    a = b - a;
                    l++;
                }
                res = Math.max(res, l);
            }
        return res > 2 ? res : 0;
    }

    public int lenLongestFibSubseq2(int[] A) {
        if(A == null || A.length == 0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<A.length; ++i)
            map.put(A[i],i);
        int maxLen = 0;
        for(int i=0; i<A.length; ++i){
            for(int j=i+1; j<A.length; ++j){
                int left = i, right = j, count = 0;
                while(map.containsKey(A[left] + A[right])){
                    int temp = right;
                    right = map.get(A[left] + A[right]);
                    left = temp;
                    count ++;
                }
                // if exists a sequence, add first 2 nums
                if(count != 0){
                    count += 2;
                    maxLen = Math.max(maxLen,count);
                }
            }
        }
        return maxLen;
    }

//    For each A[i] find previous 2 elements sum up to A[i],
//    then it's a classical follow up problem for Two Sum
//            167. Two Sum II - Input array is sorted
//if 2 elements A[l] and A[r] sum up to A[i]
//    dp[r][i]: length of longest fibonacchi sequence end with A[r], A[i]
//    dp[r][i] = dp[l][r] + 1
//            return the max(all posible dp[r][i])

    public int lenLongestFibSubseq3(int[] A) {
        int n = A.length;
        int max = 0;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int sum = A[l] + A[r];
                if (sum > A[i]) {
                    r--;
                } else if (sum < A[i]) {
                    l++;
                } else {
                    dp[r][i] = dp[l][r] + 1;
                    max = Math.max(max, dp[r][i]);
                    r--;
                    l++;
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
//    Time Complexity: O(N^2)
//    Space Complexity: O(N^2)
}
