package main.FAANG.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubarrayswithKDifferentIntegers {
    public static void main(String[] args) {
        int[] a={1,2,1,2,3};
        SubarrayswithKDifferentIntegers s=new SubarrayswithKDifferentIntegers();
        System.out.println(s.subarraysWithKDistinct2(a,2));
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        int res = 0, prefix = 0;
        int start = 0;
        int distinctCount = 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        for(int right = 0; right < A.length; right++) {
            int rightNum = A[right];

            if (!countMap.containsKey(rightNum) || countMap.get(rightNum) == 0) {
                distinctCount++;
            }

            countMap.put(rightNum, countMap.getOrDefault(rightNum, 0) + 1);

            if (distinctCount > K) {
                int startNum = A[start];
                start++;
                prefix = 0;
                countMap.put(startNum, countMap.get(startNum) - 1);
                distinctCount--;
            }

            while (countMap.get(A[start]) > 1) {
                int startNum = A[start++];
                countMap.put(startNum, countMap.get(startNum) - 1);
                prefix++;
            }

            if (distinctCount == K) {
                res += prefix + 1;
            }

        }
        return res;
    }

    //This problem will be a very typical sliding window,
    //if it asks the number of subarrays with at most K distinct elements.
    //Just need one more step to reach the folloing equation:
    //exactly(K) = atMost(K) - atMost(K-1)
    public int subarraysWithKDistinct2(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    int atMostK(int[] A, int K) {
        int i = 0, res = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int j = 0; j < A.length; ++j) {
            if (count.getOrDefault(A[j], 0) == 0) K--;
            count.put(A[j], count.getOrDefault(A[j], 0) + 1);
            while (K < 0) {
                count.put(A[i], count.get(A[i]) - 1);
                if (count.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }

    //https://leetcode.com/problems/subarrays-with-k-different-integers/discuss/262299/Single-pass-two-pointer-4ms-Java-solution-beats-100-O(N)-space
    public int subarraysWithKDistinct3(int[] A, int K) {
        int nvals[] = new int[A.length + 1];
        int nsub = 1;
        int l = 0;
        int r = 0;
        int totalsub = 0;
        while (r < A.length) {
            if (nvals[A[r++]]++ == 0) {
                K--;
            }
            if (K < 0) {
                --nvals[A[l++]];
                K++;
                nsub = 1;
            }
            if (K == 0) {
                while (nvals[A[l]] > 1) {
                    --nvals[A[l++]];
                    nsub++;
                }
                totalsub += nsub;
            }
        }
        return totalsub;
    }

}

