package main.ArrayUtils;

import java.util.Stack;


public class NextGreaterElement {

  public static void main(String[] args)
  {
   // int arr[] = { 4, 5, 2, 25};
   // int arr[] = { 4,8,5,2,25};
    int arr[] = {1, 6, 4,10, 2, 5};
    int n = arr.length;

      printNGE(arr, n);
      //printNSE(arr,n);
      //printPrevSmall(arr,n);
  }

  private static void printPrevSmall(int[] arr, int n) {

    Stack<Integer> s = new Stack<Integer>();

    for(int i=0;i<n;i++){
      int next=arr[i];
      while(!s.empty() && next<=s.peek()){
        s.pop();
      }
      if (s.empty()) {
        System.out.println(next+" prev small ele is "+"_");
      } else //Else print the nearest smaller element
      {
        System.out.println(next+" prev small ele is "+s.peek());
      }
      s.push(arr[i]);
    }
  }

  private static void printNSE(int[] arr, int n) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(arr[0]);
    for(int i=1;i<n;i++){
      int next=arr[i];
      while(!s.empty() && next<s.peek()){
        System.out.println("NSE of "+ s.pop() +" is "+next);
      }
      s.push(arr[i]);
    }
    while(!s.empty()){
      int next = -1;
      System.out.println("NSE of "+ s.pop() +" is "+next);
    }
  }

  // int arr[] = {1, 6, 4,10, 2, 5};

  private static void printNGE(int[] arr, int n) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(arr[0]);
    for(int i=1;i<n;i++){
      int next=arr[i];
      while(!s.empty() && next>s.peek()){
        System.out.println("NGE of "+ s.pop() +" is "+next);
      }
      s.push(arr[i]);
    }
    while(!s.empty()){
      int next = -1;
      System.out.println("NGE of "+ s.pop() +" is "+next);

    }
  }

}
