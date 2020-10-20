package main.ArrayUtils;

import java.util.Stack;

public class NextSmallerElement {
  /* prints element and NSE pair for all
      elements of arr[] of size n */
  public static void printNSE(int arr[], int n)
  {
    Stack<Integer> s = new Stack<Integer>();

    /* push the first element to stack */
    s.push(arr[0]);

    // iterate for rest of the elements
    for (int i = 1; i < n; i++) {

      if (s.empty()) {
        s.push(arr[i]);
        continue;
      }


        /* if stack is not empty, then
        pop an element from stack.
        If the popped element is smaller
        than next, then
        a) print the pair
        b) keep popping while elements are
        smaller and stack is not empty */
      while (s.empty() == false && s.peek() > arr[i]) {
        System.out.println(s.peek() + " --> " + arr[i]);
        s.pop();
      }
       /* push next to stack so that we can find
        next smaller for it */
      s.push(arr[i]);
    }

        /* After iterating over the loop, the remaining
        elements in stack do not have the next smaller
        element, so print -1 for them */
    while (s.empty() == false) {
      System.out.println(s.peek() + " --> " + "-1");
      s.pop();
    }
  }

  /* Driver program to test above functions */
  public static void main (String[] args) {
    int arr[] = { 4,8,5,2,25};
    int n = arr.length;
    printNSE(arr, n);
  }
}
