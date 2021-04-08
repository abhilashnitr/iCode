package main.FAANG.TwoPointers;

import java.util.ArrayList;
import java.util.List;

//986. Interval List Intersections
//You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
//
//Return the intersection of these two interval lists.
//
//A closed interval [a, b] (with a < b) denotes the set of real numbers x with a <= x <= b.
//
//The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].
public class LC986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> res = new ArrayList<>();

        while(i < firstList.length && j < secondList.length) {
            int[] first = firstList[i];
            int[] second = secondList[j];

            int[] intersect = intersection(first, second);

            if(intersect != null) {
                res.add(intersect);
            }

            if(first[1] < second[1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] result = new int[res.size()][2];
        for(int k = 0; k < res.size(); k++) {
            result[k] = res.get(k);
        }
        return result;
    }

    public int[] intersection(int[] first, int[] second) {
        if(first[1] < second[0] || second[1] < first[0]) {
            return null;
        }

        return new int[]{Math.max(first[0], second[0]), Math.min(first[1], second[1])};
    }
}
