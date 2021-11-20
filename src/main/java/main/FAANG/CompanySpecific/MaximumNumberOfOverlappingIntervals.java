package main.FAANG.CompanySpecific;

import java.util.Arrays;

//https://www.geeksforgeeks.org/maximum-number-of-overlapping-intervals/
public class MaximumNumberOfOverlappingIntervals {
    public static void main(String[] args) {

    }

    public static int maxOverlapIntervalCount(int[] start, int[] end){
        int maxOverlap = 0;
        int currentOverlap = 0;

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int m=start.length,n=end.length;
        while(i< m && j < n){
            if(start[i] < end[j]){
                currentOverlap++;
                maxOverlap = Math.max(maxOverlap, currentOverlap);
                i++;
            }
            else{
                currentOverlap--;
                j++;
            }
        }

        return maxOverlap;
    }
}
