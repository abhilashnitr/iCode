package main.StackQueueUtils;

import java.util.Stack;

public class MinStack {

  public static void main(String[] args) {
    MinStackUtil mst=new MinStackUtil();
    mst.pushUtil(10);
    mst.pushUtil(5);
    mst.pushUtil(6);
    mst.pushUtil(7);
    mst.pushUtil(3);
    mst.pushUtil(8);
    mst.pushUtil(5);
    mst.popUtil();
    mst.popUtil();
    mst.popUtil();
    mst.popUtil();
    mst.popUtil();
    mst.popUtil();
    mst.popUtil();
    mst.popUtil();
  }
}

class MinStackUtil{
  public int min;
  Stack <Integer> st;
  MinStackUtil(){
    st=new Stack<>();
  }
  public void pushUtil(int x){
    if(st.empty()){
      st.push(x);
      min=x;
    }
    else {
      if(x<min){
        st.push(2*x-min);
        min=x;
      }
      else {
        st.push(x);
      }
    }
    System.out.println(x+"Inserted and min value is "+ min);
  }
  public int popUtil(){
    
    if(st.empty()){
      return -1;
    }
    else {
      int x=st.pop();
      if(x>min)
      {
        System.out.println("popped item is "+x+"and Min is "+min);
        return x;
      }

      else
      {
        int temp=min;
        min=2*min-x;
        System.out.println("popped item is "+temp+"and Min is "+min);
        return temp;
      }

    }


  }
  public int getMin(){
    return min;
  }
}
