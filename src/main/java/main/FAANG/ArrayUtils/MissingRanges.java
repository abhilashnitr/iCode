package main.FAANG.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

// You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
// A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
// Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
// Each range [a,b] in the list should be output as:
// "a->b" if a != b
// "a" if a == b
public class MissingRanges {
    public List<String> findMissingRanges(int[] a, int lo, int hi) {
        List<String> res = new ArrayList<String>();

        // the next number we need to find
        int next = lo;

        for (int i = 0; i < a.length; i++) {
            // not within the range yet
            if (a[i] < next) continue;

            // continue to find the next one
            if (a[i] == next) {
                next++;
                continue;
            }

            // get the missing range string format
            res.add(getRange(next, a[i] - 1));

            // now we need to find the next number
            next = a[i] + 1;
        }

        // do a final check
        if (next <= hi) res.add(getRange(next, hi));

        return res;
    }

    String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }

    public List<String> findMissingRanges2(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        if(nums == null) return list;
        int n = nums.length;
        for(int i = 0; i <= n; i++) {
            int lt = (i == 0) ? lower : nums[i - 1] + 1;
            int gt = (i == n) ? upper : nums[i] - 1;
            addRange(list, lt, gt);
        }
        return list;
    }
    private void addRange(List<String> list, int lo, int hi) {
        if(lo > hi) return;
        else if(lo == hi) list.add(String.valueOf(lo));
        else list.add(lo + "->" + hi);
    }


    public List<String> findMissingRanges3(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int prev = lower - 1;
        for (int i = 0; i <= nums.length; i++) {
            int curr = (i < nums.length) ? nums[i] : upper + 1;
            if (prev + 1 <= curr - 1) {
                result.add(formatRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return result;
    }

    // formats range in the requested format
    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        }
        return lower + "->" + upper;
    }
}
