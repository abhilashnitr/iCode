package main.StackQueueUtils;

import java.util.Stack;

public class PreviousSmallerElement {

  public static void main (String[] args)
  {
    int []arr = {1, 3, 0, 2, 5};
    int n = arr.length;
    printPrevSmaller(arr, n);
  }

  private static void printPrevSmaller(int[] arr, int n) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(arr[0]);
    System.out.print("-1, ");
    for (int i = 1; i < n; i++) {
      while (s.empty() == false &&
          s.peek() > arr[i]) {
        s.pop();
      }
      if (s.empty() == true) {
        System.out.print("-1, ");
      } else {
        System.out.print(s.peek() + ", ");
      }

      s.push(arr[i]);
    }
  }


}


/*
1) Create a new empty stack S
2) For every element 'arr[i]' in the input sequence 'arr[]',
   where 'i' goes from 0 to n-1.
    a) while S is nonempty and the top element of
       S is greater than or equal to 'arr[i]':
           pop S
    b) if S is empty:
           'arr[i]' has no preceding smaller value
    c) else:
           the nearest smaller value to 'arr[i]' is
           the top element of S
    d) push 'arr[i]' onto S
*/