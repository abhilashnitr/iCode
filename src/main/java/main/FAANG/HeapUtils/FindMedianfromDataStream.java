package main.FAANG.HeapUtils;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {


    private PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian() {
        if (even)
            return (max.peek() + min.peek()) / 2.0;
        else
            return max.peek();
    }

    public void addNum(int num) {
        if (even) {
            min.offer(num);
            max.offer(min.poll());
        } else {
            max.offer(num);
            min.offer(max.poll());
        }
        even = !even;
    }
    // we always maintainn that maximum element of maxheap is less than minimum element of MinHeap
    // Any time before we add a new number, there are two scenarios, (total n numbers, k = n / 2):
    // n = even
    //(1) length of (min, max) == (k, k)            //Here final edition in max Heap
    //(2) length of (min, max) == (k, k + 1)    min.offer(num);  max.offer(min.poll());
    // After adding the number, total (n + 1) numbers, they will become:
    // n = odd
    //(1) length of (min, max) == (k, k + 1)        //Here final edition in min Heap
    //(2) length of (min, max) == (k + 1, k + 1)    max.offer(num);  min.offer(max.poll());
}
