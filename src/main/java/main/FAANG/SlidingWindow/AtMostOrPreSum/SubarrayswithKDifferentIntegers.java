package main.FAANG.SlidingWindow.AtMostOrPreSum;

import java.util.HashMap;
import java.util.Map;

public class SubarrayswithKDifferentIntegers {
    public static void main(String[] args) {
        int[] a={1,1,2,1,2,3};
        SubarrayswithKDifferentIntegers s=new SubarrayswithKDifferentIntegers();
        System.out.println(s.subarraysWithKDistinct(a,2));
    }


    public int subarraysWithKDistinct4(int[] A, int K) {
        return atMost(A, K)- atMost(A, K- 1);
    }

    public int atMost(int[] A, int k) {
        int n = A.length;
        int res=0;
        int low=0,high;
        Map<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(high=0;high<n;high++){
            int highNum=A[high];
            if(count.getOrDefault(highNum,0)==0)
                k--;
            count.put(highNum,count.getOrDefault(highNum,0)+1);
            while(k<0){
                count.put(A[low], count.get(A[low]) - 1);
                if (count.get(A[low]) == 0) k++;
                low++;
            }
            res+=high-low+1;

        }
        return res;
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

