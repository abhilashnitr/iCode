package main.FAANG.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/143726/C%2B%2BJavaPython-O(N)-Using-Deque
public class ShortestSubarraywithSumatLeastK {

    public static void main(String[] args) {
        //int[] a={84,-37,32,40,95};
        int[] a={84,-5,10,5};
        int k=89;

        ShortestSubarraywithSumatLeastK main=new ShortestSubarraywithSumatLeastK();
        System.out.println(main.shortestSubarray2(a,k));
    }

    public int shortestSubarray2(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] B = new int[N + 1];
        for (int i = 0; i < N; i++) B[i + 1] = B[i] + A[i];
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >=  K)
                res = Math.min(res, i - d.pollFirst());
            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();
            d.addLast(i);
        }
        return res <= N ? res : -1;
    }

    public int shortestSubarray(int[] A, int K) {
        if (A.length == 0) return -1;
        TreeMap<Long, Integer> tree = new TreeMap<>();
        long total = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            long x=total-K;
            Long num = tree.floorKey(x);
            if (total >= K) {
                if (i+1 < minLen) {
                    minLen = i+1;
                }
            }
            while (num != null) {
                if (i-tree.get(num) < minLen) {
                    minLen = i-tree.get(num);
                }
                tree.remove(num);
                num = tree.lowerKey(num);
            }
            tree.put(total, i);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
