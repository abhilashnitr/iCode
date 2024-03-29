package main.FAANG.HeapUtils;

import java.util.PriorityQueue;

// using a minn heap
public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    //O(N lg K) running time + O(K) memory

}
