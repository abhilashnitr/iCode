package main.FAANG.ArrayUtils;

import java.util.SortedSet;
import java.util.TreeSet;

//Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute
// difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
//Input: nums = [1,2,3,1], k = 3, t = 0
//Output: true
//Input: nums = [1,0,1,1], k = 1, t = 2
//Output: true
//Input: nums = [1,5,9,1,5,9], k = 2, t = 3
//Output: false
public class ContainsDuplicateIII {

    //Initialize an empty BST set
    //Loop through the array, for each element xx
    //Find the smallest element ss in set that is greater than or equal to xx, return true if s - x \leq ts−x≤t
    //Find the greatest element gg in set that is smaller than or equal to xx, return true if x - g \leq tx−g≤t
    //Put xx in set
    //If the size of the set is larger than kk, remove the oldest item.


    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= g + t) return true;

            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if(nums==null||nums.length<2||k<0||t<0)
            return false;

        TreeSet<Long> set = new TreeSet<Long>();
        for(int i=0; i<nums.length; i++){
            long curr = (long) nums[i];

            long leftBoundary = (long) curr-t;
            long rightBoundary = (long) curr+t+1; //right boundary is exclusive, so +1
            SortedSet<Long> sub = set.subSet(leftBoundary, rightBoundary);
            if(sub.size()>0)
                return true;

            set.add(curr);

            if(i>=k){ // or if(set.size()>=k+1)
                set.remove((long)nums[i-k]);
            }
        }

        return false;
    }


}
