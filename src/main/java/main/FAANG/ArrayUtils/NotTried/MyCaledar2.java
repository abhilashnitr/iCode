package main.FAANG.ArrayUtils.NotTried;

import java.util.Map;
import java.util.TreeMap;

//Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a
// triple booking.
//Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open
// interval [start, end), the range of real numbers x such that start <= x < end.
//A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to
// all 3 events.)
//For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without
// causing a triple booking. Otherwise, return false and do not add the event to the calendar.
//MyCalendar();
//MyCalendar.book(10, 20); // returns true
//MyCalendar.book(50, 60); // returns true
//MyCalendar.book(10, 40); // returns true
//MyCalendar.book(5, 15); // returns false
//MyCalendar.book(5, 10); // returns true
//MyCalendar.book(25, 55); // returns true
public class MyCaledar2 {

    private TreeMap<Integer, Integer> map;

    public MyCaledar2() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if(count > 2) {
                map.put(start, map.get(start) - 1);
                if(map.get(start) == 0) {
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if(map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }

}
