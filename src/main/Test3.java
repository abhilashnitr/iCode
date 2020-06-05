package main;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

  public static void main (String[] args) {
    List<Integer> list=new ArrayList<>();
    list.add(5);
    list.add(2);
    list.add(3);
    list.add(1);
    list.add(4);
    int count=getCount(list);
    System.out.println(count);
  }

  private static int getCount (List<Integer> list) {
    int n=list.size();
    if(n<3)
      return 0;
    int[] leftMax=new int[n];
    int[] rightMax=new int[n];
    int[] leftMin=new int[n];
    int[] rightMin=new int[n];
    int result=0;
    for(int i=1;i<n-1;i++){
      for(int j=0;j<i;j++){
        if(list.get(j)>list.get(i))
          leftMax[i]++;
        if(list.get(j)<list.get(i))
          leftMin[i]++;
      }
    }
    for(int i=1;i<n-1;i++){
      for(int j=n-1;j>i;j--){
        if(list.get(j)>list.get(i))
          rightMax[i]++;
        if(list.get(j)<list.get(i))
          rightMin[i]++;
      }
    }

    for(int i=1;i<n-1;i++){
      if(leftMax[i]!=0&&rightMin[i]!=0)
        result+=leftMax[i]*rightMin[i];
      if(leftMin[i]!=0&&rightMax[i]!=0)
        result+=leftMin[i]*rightMax[i];
    }

    return result;
  }

}
