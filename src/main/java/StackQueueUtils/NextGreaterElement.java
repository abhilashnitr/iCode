package StackQueueUtils;

import java.util.Stack;

public class NextGreaterElement {

  public static void main(String[] args) {
    int[] a={4,5,6,7,20,9,45,18};
    nextGreaterElement(a);
  }

  private static void nextGreaterElement(int[] a) {
    Stack<Integer> st=new Stack<>();

    st.add(a[0]);

    for(int i=1;i<a.length;i++){
      if (!st.empty()) {
        while(st.peek() < a[i]) {
          System.out.println("Next Greater Element of " + st.pop() + " is " + a[i]);
          if (st.isEmpty() == true)
            break;
        }
        }
      st.push(a[i]);
    }
    while(!st.isEmpty()){
      System.out.println("Next Greater Element of "+st.pop() +" is -1");
    }
  }

}
