package StackQueueUtils;

import java.util.Stack;

public class NextSmallerElement {

  public static void main(String[] args) {
    int[] a={ 11, 13, 21, 3};
    nextSmallerElement(a);
  }

  private static void nextSmallerElement(int[] a) {
    Stack<Integer> st=new Stack<>();

    st.add(a[0]);

    for(int i=1;i<a.length;i++){
      if (!st.empty()) {
        while(st.peek() > a[i]) {
          System.out.println("Next Smaller Element of " + st.pop() + " is " + a[i]);
          if (st.isEmpty() == true)
            break;
        }
      }
      st.push(a[i]);
    }
    while(!st.isEmpty()){
      System.out.println("Next Smaller Element of "+st.pop() +" is -1");
    }
  }


}
