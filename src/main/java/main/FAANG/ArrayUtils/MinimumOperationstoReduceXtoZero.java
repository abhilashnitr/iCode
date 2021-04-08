package main.FAANG.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationstoReduceXtoZero {
    //This problem is closely related to Maximum Size Subarray Sum Equals k.
    //shortest subarray with sum x = logest subarray with sum total - x
    //Step 1: Calculate the total sum of nums. Mark as total.
    //
    //Step 2: Initialize two pointers left and right to 0. Initialize an integer current to represent the sum from nums[left] to nums[right], inclusively. Initialize an integer maxi to record the maximum length that sums up to total - x.
    //
    //Step 3: Iterate right form 0 to the end of nums. In each iteration:
    //
    //Update current.
    //If current is greater than total - x, move left to left.
    //If current is equal to total - x, update the maximum length.
    //Step 4: Return the result.
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int n = nums.length;
        int maxi = -1;
        int left = 0;
        int current = 0;

        for (int right = 0; right < n; right++) {
            // sum([left ,..., right]) = total - x
            current += nums[right];
            // if larger, move `left` to left
            while (current > total - x && left <= right) {
                current -= nums[left];
                left += 1;
            }
            // check if equal
            if (current == total - x) {
                maxi = Math.max(maxi, right - left + 1);
            }
        }
        return maxi != -1 ? n - maxi : -1;
    }

    /*
       This question is the equivalent of asking: What's the length of the longest subarray that adds up to the total sum
       of all elements in the array, minus x? Let's say this subarray adds up to the variable target.

       Once we've got the answer to that question in a variable res, we can answer the original question by
       subtracting the resulting length from the total length of the array, since that's the number of
       operations we'd need to perform to produce the subarray, or nums.length - res.
    */
    public int minOperations2(int[] nums, int x) {
        int target = -x;
        for (int num : nums) target += num; // These two steps are just setting our target = totalSum - x

        /* If your totalSum = x, the longest subarray that adds up to x is the entire array. */
        if (target == 0) return nums.length;



        /*
            The following map stores a map from a prefix sum to the index where it occurs. It answers the
            question: How many elements in a row from the left side do I need to grab to get a sum adding up to k? If I call
            map.get(k), I will get the answer.
        */
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // We set this to -1 because it is a special case, and I will address it later.

        int res = Integer.MIN_VALUE; // This will store the length of the longest subarray

        /*
            Now, we're going to step through the array from left to right, using an index i, and adding to a sum.
            We're trying to find the longest subarray that adds up to our target value.

            On each step i, the current sum is the equivalent of considering a range of elements where
            all elements to the right of i have been excluded from our current subarray. To think back to our
            original problem, it's like performing nums.length - i operations on the right side.
        */
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {

            sum += nums[i];

            /*
                At this point, we've excluded nums.length - i from the right side, and the sum of all
                elements to the left of and including i is stored in the sum variable. I'd like to know
                if I can exclude some number of elements from the left side of my current subarray
                so that my subarray sum is equal to target. Since we store prefix sums in the map,
                I'd like to know if there's a nice prefix I can use that will help me accomplish this.

                Mathematically, nice_prefix + target = sum, so I want to check if the map contains
                nice_prefix = target - sum .

            */
            if (map.containsKey(sum - target)) {

                /*
                    So, I've found the nice prefix I need from the prefix map. Let's say that the nice prefix
                    mapped to an index a. Now, I have a subarray in the middle of the array that adds up to target,
                    where the first a elements and the last nums.length - i elements are excluded.
                    What's the length of my current subarray? It's i - a.

                    I need to check if this resulting length i - a is better than what I've previously found.

                    What happens if sum = target? In that case, we don't need to exclude any elements
                    from the left side. What's the length of my subarray in this case? It's i + 1, since our
                    arrays are zero-indexed. Thus, in my map, I need to store - 1 so that the subtraction i - a
                    evaluates to i + 1. This is why we made a map.put(0, -1) call earlier.

                */
                res = Math.max(res, i - map.get(sum - target));
            }

            /*
                It looks like we couldn't find the prefix we needed, so let's store the current sum
                (which is a prefix of elements up to index i) in the map. Since all numbers in the array
                are positive, the sum will always increase with every step of the loop, so we don't
                have to worry about uniqueness.
            */
            map.put(sum, i);
        }

        /*
            Now, we've found the length of the longest subarray that adds up to target, and stored in res.
            We need to answer our original question, which was the number of operations applied to both
            sides to reach x. To get this value, we return nums.length - res.

            If we didn't find a subarray that added up to target, our result value should still be its
            initial value, Integer.MIN_VALUE. In that case, no number of operations on either side
            will allow us to reduce x to 0.
        */

        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}
