package DP_utils;

import java.util.Stack;

public class LargestAreaInHistogram {

    public static void main(String[] args)
    {
      int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
      System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }

  public static int getMaxArea(int[] hist, int n) {
    Stack<Integer> s = new Stack<>();

    int max_area = 0; // Initialize max area
    int tp;  // To store top of stack
    int area_with_top; // To store area with top bar as the smallest bar


    int i = 0;
    while (i < n)
    {
      if (s.empty() || hist[s.peek()] <= hist[i])
        s.push(i++);

        // If this bar is lower than top of stack, then calculate area of rectangle
        // with stack top as the smallest (or minimum height) bar. 'i' is
        // 'right index' for the top and element before top in stack is 'left index'
      else
      {
        tp = s.peek();  // store the top index
        s.pop();  // pop the top
        area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

        // update max area, if needed
        if (max_area < area_with_top)
          max_area = area_with_top;
      }
    }


    while (s.empty() == false)
    {
      tp = s.peek();
      s.pop();
      area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

      if (max_area < area_with_top)
        max_area = area_with_top;
    }

    return max_area;
  }



}
