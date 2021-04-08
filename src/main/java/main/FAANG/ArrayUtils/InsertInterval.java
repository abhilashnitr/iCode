package main.FAANG.ArrayUtils;


import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start)
                result.add(i);
            else if (i.start > newInterval.end) {
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        if (newInterval != null)
            result.add(newInterval);
        return result;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();

        for(int[] i : intervals){
            if(newInterval == null || i[1] < newInterval[0]){
                result.add(i);
            }else if(i[0] > newInterval[1]){
                // be carefult the sequence here
                result.add(newInterval);
                result.add(i);
                newInterval = null;
            }else{

                newInterval[0] = Math.min(newInterval[0], i[0]);//get min
                newInterval[1] = Math.max(newInterval[1], i[1]);//get max
            }
        }

        if(newInterval != null)
            result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}
