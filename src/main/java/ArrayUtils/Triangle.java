package ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
*/
public class Triangle {

  public static void main(String[] args) {
    List<List<Integer>> lists=new ArrayList<>();
    List<Integer> list1= Arrays.asList(2);
    List<Integer> list2= Arrays.asList(3,4);
    List<Integer> list3= Arrays.asList(6,5,7);
    List<Integer> list4= Arrays.asList(4,1,8,3);
    lists.add(list1);
    lists.add(list2);
    lists.add(list3);
    lists.add(list4);
    System.out.println(minimumTotal(lists));
  }
  public static int minimumTotal(List<List<Integer>> triangle) {
    int[] A = new int[triangle.size()+1];
    for(int i=triangle.size()-1;i>=0;i--){
      for(int j=0;j<triangle.get(i).size();j++){
        A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
      }
    }
    return A[0];
  }

}
