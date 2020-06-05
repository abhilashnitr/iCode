package main.CoreJavaUtils;

import java.util.*;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{


  public static void main(String[] args) {
    List<String> list=new ArrayList<>();
    list.add("mi2 jog mid pet");
    list.add("wz3 34 54 398");
    list.add("a1 alps cow bar");
    list.add("x4 45 21 7");

    Solution s=new Solution();
    s.reorderLines(4,list);
    System.out.println(list);

  }
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  public List<String> reorderLines(int logFileSize, List<String> logLines)
  {
    // WRITE YOUR CODE HERE

    Comparator<String> comparator=new Comparator<String>(){

      public int compare(String s1,String s2){
        String[] s1Arr=s1.split(" ");
        String[] s2Arr=s2.split(" ");

        if(!checkNumeic(s2Arr[1])&&!checkNumeic(s2Arr[1])){
          if(checkStringArray(s1Arr,s2Arr))
            return s1Arr[0].compareTo(s2Arr[0]);
          for(int i=1;i<s1.length();i++){
            if(!s1Arr[i].equals(s2Arr[i]))
              return s2Arr[i].compareTo(s1Arr[i]);
          }
        }
        if(checkNumeic(s1Arr[1])&&checkNumeic(s2Arr[1])){
          return 1;
        }else if(checkNumeic(s1Arr[1])){
          return 1;
        }else{
          return -1;
        }
      }
    };

    Collections.sort(logLines,comparator);
    return logLines;

  }

  boolean checkStringArray(String[] s1,String[] s2){
    for(int i=1;i<s1.length;i++){
      if(!s1[i].equals(s2[i]))
        return false;
    }
    return true;
  }

  boolean checkNumeic(String s){
    boolean numeric=true;

    try{
      Integer.parseInt(s);
    }catch(NumberFormatException e){
      numeric=false;
    }
    return numeric;
  }
  // METHOD SIGNATURE ENDS
}
