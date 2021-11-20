package main.FAANG.HeapUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
//
//Define a pair (u, v) which consists of one element from the first array and one element from the second array.
//
//Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
//Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//Output: [[1,2],[1,4],[1,6]]
//Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
public class FindKPairswithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        int m = nums1.length, n = nums2.length;
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0) return res;
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, nums1[0]+nums2[j]));
        for(int i = 0; i < Math.min(k, m *n); i++) {
            Tuple t = pq.poll();
            res.add(new int[]{nums1[t.x], nums2[t.y]});
            if(t.x == m - 1) continue;
            pq.offer(new Tuple (t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }
        return res;
    }
}

