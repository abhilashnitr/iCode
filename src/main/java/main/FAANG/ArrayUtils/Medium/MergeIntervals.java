package main.FAANG.ArrayUtils.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
// of the non-overlapping intervals that cover all the intervals in the input.
public class MergeIntervals {
    //The idea is to sort the intervals by their starting points. Then, we take the first interval and compare its end
    // with the next intervals starts. As long as they overlap, we update the end to be the max end of the overlapping
    // intervals. Once we find a non overlapping interval, we can add the previous "extended" interval and start over.


    public static void main(String[] args) {
        int[][] interval={{1,3},{2,6},{8,10},{15,18}};
        MergeIntervals mergeIntervals=new MergeIntervals();
        int[][] ans=mergeIntervals.merge(interval);

        for (int[] an : ans) System.out.println(an[0] + " " + an[1]);
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
