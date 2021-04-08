package main.FAANG.ArrayUtils;

import java.util.Stack;

public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] h) {
        int n = h.length, i = 0, max = 0;

        Stack<Integer> s = new Stack<>();

        while (i < n) {
            // as long as the current bar is shorter than the last one in the stack
            // we keep popping out the stack and calculate the area based on
            // the popped bar
            while (!s.isEmpty() && h[i] < h[s.peek()]) {
                // tricky part is how to handle the index of the left bound
                max = Math.max(max, h[s.pop()] * (i - (s.isEmpty() ? 0 : s.peek() + 1)));
            }
            // put current bar's index to the stack
            s.push(i++);
        }

        // finally pop out any bar left in the stack and calculate the area based on it
        while (!s.isEmpty()) {
            max = Math.max(max, h[s.pop()] * (n - (s.isEmpty() ? 0 : s.peek() + 1)));
        }

        return max;

    }
    //Two key points that I found helpful while understanding the solution:
    //
    //When a bar is popped, we calculate the area with the popped bar at index tp as shortest bar. Now we know the
    // rectangle height is heights[tp], we just need rectangle width to calculate the area.

    //How to determine rectangle width? The maximum width we can have here would be made of all connecting bars with
    // height greater than or equal to heights[tp]. heights[s.peek() + 1] >= heights[tp] because the index on top of the
    // stack right now s.peek() is the first index left of tp with height smaller than tp's height (if s.peek() was
    // greater then it should have already been poped out of the stack). heights[i - 1] >= heights[tp] because index i
    // is the first index right of tp with height smaller than tp's height (if i was greater then tp would have remained
    // on the stack). Now we multiply height heights[tp] by width i - 1 - s.peek() to get the area.
}
