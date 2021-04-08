package main.FAANG.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//MyCalendar();
//MyCalendar.book(10, 20); // returns true
//MyCalendar.book(15, 25); // returns false
//MyCalendar.book(20, 30); // returns true
public class MyCalendarI {

    //Evidently, two events [s1, e1) and [s2, e2) do not conflict if and only if one of them starts after the other one
    // ends: either e1 <= s2 OR e2 <= s1
    List<int[]> calendar;
    TreeMap<Integer, Integer> calendar2;


    MyCalendarI() {
        calendar = new ArrayList();
        calendar2 = new TreeMap();
    }

    public boolean book(int start, int end) {
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }
    //Time - O(N^2)
    //Space - O(N)

    //using balanced tree

    public boolean book2(int start, int end) {
        Integer prev = calendar2.floorKey(start),
                next = calendar2.ceilingKey(start);
        if ((prev == null || calendar2.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar2.put(start, end);
            return true;
        }
        return false;
    }
    //Time - O(NlogN)
    //Space - O(N)

}
