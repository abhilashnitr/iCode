package main.FAANG.HeapUtils;

import java.util.*;

public class SlidingWindowMedian {

    public double[] medianSlidingWindow2(int[] nums, int k) {
        int len = nums.length, p = 0;
        double[] sol = new double[len - k + 1];
        boolean flag = (k % 2 == 0);
        List<Integer> list = new ArrayList<>();

        //Insert first k-1 elements into the Arraylist
        for (int j = 0; j < k - 1; j++) list.add(nums[j]);

        //sort the initial list with k-1 elements, later on we will just add and remove elements from this sorted list
        Collections.sort(list);

        for (int i = k - 1; i < len; i++) {
            //Binary search if the element is already present in the list
            //below function returns index if the element is present else it returns the  -(expected position +1) , yeah thats the negative sign
            int expectedindex = Collections.binarySearch(list, nums[i]);

            if (expectedindex > -1) {
                list.add(expectedindex + 1, nums[i]); // add just next to it
            }
            else {
                list.add(Math.abs(expectedindex + 1), nums[i]); // add it in its expected position
            }

            //Insert into the sol list the median according to the value of k
            if (flag) {
                sol[i - k + 1] = list.get((k / 2) - 1) / 2.0 + list.get((k / 2)) / 2.0;
            } else {
                sol[i - k + 1] = list.get((k / 2));
            }

            // when the window slides by one element, we just find its positon in the sorted list and delete it
            int index = Collections.binarySearch(list, nums[p]);
            list.remove(index);
            p++;
        }

        return sol;
    }

    //O(nlogk)
    static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
            Comparator.reverseOrder()
    );

    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        Arrays.stream(medianSlidingWindow(nums,k)).forEach(System.out::println);

    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) return new double[0];
        double[] result = new double[n];

        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }

        return result;
    }

    private static void add(int num) {
        if (num < getMedian()) {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private static void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        }
        else {
            minHeap.remove(num);
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }

    private static double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;

        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
        else {
            return (double)minHeap.peek();
        }
    }
}
