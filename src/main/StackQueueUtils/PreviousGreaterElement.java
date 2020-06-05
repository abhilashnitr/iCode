package main.StackQueueUtils;

import java.util.Stack;

public class PreviousGreaterElement {
  public static void main(String[] args)
  {
    int arr[] = { 10, 4, 2, 20, 40, 12, 30 };
    int n = arr.length;
    prevGreater(arr, n);
  }

  private static void prevGreater(int[] arr, int n) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(arr[0]);
    System.out.print("-1, ");
    for (int i = 1; i < n; i++)
    {
      while (s.empty() == false &&
          s.peek() < arr[i])
        s.pop();
      if (s.empty() == true)
        System.out.print("-1, ");
      else
        System.out.print(s.peek() + ", ");

      s.push(arr[i]);
    }
    }
}
