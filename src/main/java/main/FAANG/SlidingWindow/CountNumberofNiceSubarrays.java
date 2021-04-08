package main.FAANG.SlidingWindow;

import java.util.LinkedList;

//Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
//
//Return the number of nice sub-arrays.
public class CountNumberofNiceSubarrays {

    public static void main(String[] args) {
        int[] a={1,1,2,1,1};
        int k=3;
        CountNumberofNiceSubarrays c=new CountNumberofNiceSubarrays();
        System.out.println(c.numberOfSubarrays3(a,k));
    }

    public int numberOfSubarrays(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    public int atMost(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            while (k < 0)
                k += A[i++] % 2;
            res += j - i + 1;
        }
        return res;
    }

    //Whenever the count of odd numbers reach k, for each high boundary of the sliding window, we have indexOfLeftMostOddInWin - lowBound options for the low boundary, where indexOfLeftMostOddInWin is the index of the leftmost odd number within the window, and lowBound is the index of the low boundary exclusively;
    //Whenever the count of odd numbers more than k, shrink the low boundary so that the count back to k;

    public int numberOfSubarrays2(int[] nums, int k) {
        int ans = 0, indexOfLeftMostOddInWin = 0, lowBound = -1;
        for (int num : nums) {
            k -= num % 2;
            if (nums[indexOfLeftMostOddInWin] % 2 == 0) // move to the index of first odd.
                ++indexOfLeftMostOddInWin;
            if (k < 0) { // more than k odds in window, need to shrink from low bound.
                lowBound = indexOfLeftMostOddInWin; // update the low bound value.
            }
            while (k < 0) {
                k += nums[++indexOfLeftMostOddInWin] % 2; // move to the index of next odd.
            }
            if (k == 0) { // accumulated k odd numbers in window.
                ans += indexOfLeftMostOddInWin - lowBound; // update result.
            }
        }
        return ans;
    }

    public int numberOfSubarrays3(int[] nums, int k) {
        LinkedList<Integer> deq = new LinkedList();
        deq.add(-1);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 1) deq.add(i);
            if (deq.size() > k + 1) deq.pop();
            if (deq.size() == k + 1) res += deq.get(1) - deq.get(0);
        }
        return res;
    }


}
