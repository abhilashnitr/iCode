package main.StringUtils;

import java.util.Stack;

public class BackSpaceString {



  /**
   * Two pointer
   1. Thoughts
   - from back to front
   - if count > 0 && != #, skip
   - if count == 0 && different, return false
   - if #, count++
   - if one ends, the other count == 0 && has any char return false
   - else return true
   */
  public static void main (String[] args) {
    String S="XYabc###";
    String T="Xa#b#c#";

    Stack<Integer> s=new Stack<>();


    System.out.println(backspaceCompare2ptr(S,T));
  }

  public boolean backspaceCompare2ptr1(String S, String T) {
    int i = S.length() - 1, j = T.length() - 1;
    int skipS = 0, skipT = 0;

    while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
      while (i >= 0) { // Find position of next possible char in build(S)
        if (S.charAt(i) == '#') {skipS++; i--;}
        else if (skipS > 0) {skipS--; i--;}
        else break;
      }
      while (j >= 0) { // Find position of next possible char in build(T)
        if (T.charAt(j) == '#') {skipT++; j--;}
        else if (skipT > 0) {skipT--; j--;}
        else break;
      }
      // If two actual characters are different
      if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
        return false;
      // If expecting to compare char vs nothing
      if ((i >= 0) != (j >= 0))
        return false;
      i--; j--;
    }
    return true;
  }

  public static boolean backspaceCompare2ptr(String S, String T) {
    int i = S.length()-1;
    int j = T.length()-1;
    int countS = 0;
    int countT = 0;
    while (i >= 0 || j >= 0) {
      while (i >= 0 && (countS > 0 || S.charAt(i) == '#')) {
        if (S.charAt(i) == '#') countS++;
        else countS--;
        i--;
      }
      char left = i < 0 ? '@' : S.charAt(i);
      while (j >= 0 && (countT > 0 || T.charAt(j) == '#')) {
        if (T.charAt(j) == '#') countT++;
        else countT--;
        j--;
      }
      char right = j < 0 ? '@' : T.charAt(j);
      if (left != right) return false;
      i--;
      j--;
    }
    return true;
  }



  private String getString(String str) {
    int n=str.length(), count=0;
    String result="";
    for(int i=n-1; i>=0; i--) {
      char ch=str.charAt(i);
      if(ch=='#')
        count++;
      else {
        if(count>0)
          count--;
        else {
          result+=ch;
        }
      }
    }
    return result;
  }

  public boolean backspaceCompare(String S, String T) {
    return getString(S).equals(getString(T));
  }

}
