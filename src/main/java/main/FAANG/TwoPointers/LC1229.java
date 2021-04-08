package main.FAANG.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//1229. Meeting Scheduler
//Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the
// earliest time slot that works for both of them and is of duration duration.
//
//If there is no common time slot that satisfies the requirements, return an empty array.
//
//The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.
//
//It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time
// slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.
public class LC1229 {
    //two poinnter approach
    /*
Algorithm
Sort both slots1 and slots2 by the start time.
Initialize two pointers, pointer1 and pointer2, pointing to the beginning of slots1 and the beginning of slots2 respectively.
Iterate until pointer1 reaches the end of slots1 or pointer2 reaches the end of slots2:
Find the common slot of slots1[pointer1] and slots2[pointer2].
If the common slot is greater than or equal to duration, return the result.
Else, find the slot that ends earlier and move the pointer.
If no common slot is found, return an empty array
Time complexity: O(MlogM+NlogN)
*/
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);

        int pointer1 = 0, pointer2 = 0;

        while (pointer1 < slots1.length && pointer2 < slots2.length) {
            // find the boundaries of the intersection, or the common slot
            int intersectLeft = Math.max(slots1[pointer1][0], slots2[pointer2][0]);
            int intersectRight = Math.min(slots1[pointer1][1], slots2[pointer2][1]);
            if (intersectRight - intersectLeft >= duration) {
                return new ArrayList<Integer>(Arrays.asList(intersectLeft, intersectLeft + duration));
            }
            // always move the one that ends earlier
            if (slots1[pointer1][1] < slots2[pointer2][1]) {
                pointer1++;
            } else {
                pointer2++;
            }
        }
        return new ArrayList<Integer>();
    }


    //using Heap
    //Initialize a heap timeslots and push time slots that last longer than duration into it.
    //Iterate until there's only one time slot remaining in timeslots:
    //Pop the first time slot [start1, end1] from timeslots.
    //Retrieve the next time slot [start2, end2], which is the current top element in timeslots.
    //If we find end1 >= start2 + duration, because start1 > start2, the common slot is longer than duration and we can return it.
    //If we don't find the common slot that is longer than duration, return an empty array.
    public List<Integer> minAvailableDuration2(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> timeslots = new PriorityQueue<>((slot1, slot2) -> slot1[0] - slot2[0]);

        for (int[] slot: slots1) {
            if (slot[1] - slot[0] >= duration) timeslots.offer(slot);
        }
        for (int[] slot: slots2) {
            if (slot[1] - slot[0] >= duration) timeslots.offer(slot);
        }

        while (timeslots.size() > 1) {
            int[] slot1 = timeslots.poll();
            int[] slot2 = timeslots.peek();
            if (slot1[1] >= slot2[0] + duration) {
                return new ArrayList<Integer>(Arrays.asList(slot2[0], slot2[0] + duration));
            }
        }
        return new ArrayList<Integer>();
    }
    //Time complexity: O(m + n) while m, n are the length of each person's available time ranges
    //Space complexity: O(m + n) since we create a queue that hosts all the ranges
}
