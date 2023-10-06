package main.FAANG.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/*
Given an array of integers nums and an integer limit,
return the size of the longest non-empty subarray such
that the absolute difference between any two elements
of this subarr ay is less than or equal to limit.
*/
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {

    public static void main(String[] args) {
        LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit ll = new LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit();
        int[] num = {8,2,4,7};
        System.out.println(ll.longestSubarray(num,4));
    }
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int res = 1;

        int l = 0;

        // find the longest subarray for every right pointer by shrinking left pointer
        for (int r = 0; r < nums.length; ++r) {

            // update maxDeque with new right pointer
            while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[r]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(nums[r]);

            // update minDeque with new right pointer
            while (!minDeque.isEmpty() && minDeque.peekLast() > nums[r]) {
                minDeque.removeLast();
            }
            minDeque.addLast(nums[r]);

            // shrink left pointer if exceed limit
            while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[l]) maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[l]) minDeque.pollFirst();
                ++l;  // shrink it!
            }

            // update res
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}


/*
Key Notes:

1. "Absolute difference between any two elements is less than or equal to limit" is basically => "Absolute difference between min and max elements of subarray"

2. Now the question becomes => find the longest subarray in which the absolute difference between min and max is less than or equal to limit. What we can do is
to have two pointers: left and right, and then find the longest subarray for every right pointer (iterate it) by shrinking left pointer. And return the longest one among them.

3. Let's work on sliding window max first. How to efficiently find 239. sliding window maximum?
By using max Deque. We maintain list of max element candidates in monotonically decreasing order. Everytime the right pointer reaches a new position,
we need to dequeue the "tail" element who is smaller than the nums[right]. Since, those "old small tail" elements will never be the range maximum from
now on. After "clean up" the "old small tail" elements, add nums[right] into the deque, and then, the head of deque is the current maximum.

Same for the min Deque. Move right poniter by 1, and clean up "old big tail" elements, add nums[right], the head of deque is the current minimum.

What we should do next is to shrink left pointer because of limit. If current.max - current.min > limit. We should move the left pointer. Accordingdly,
we need to update our min max deques. If head of max deque is equal to the nums[left], that means, it is the one, we need to dequeue it, since we are gonna
move the left pointer by 1. (Note: nums[left] will be never larger than head of max deque, and if nums[left] is smaller than the head, we good, keep moving
left pointer until satisfying the limit).
*/