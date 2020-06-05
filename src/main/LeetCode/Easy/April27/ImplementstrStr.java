package main.LeetCode.Easy.April27;

public class ImplementstrStr {

  public static void main(String[] args) {
    System.out.println(strStr("a","a"));
  }

  public static int strStr(String haystack, String needle) {
    if(needle==null || needle.length()==0)
      return 0;
    if(haystack==null || haystack.length()<needle.length())
      return -1;
    for(int i=0;i<=haystack.length()-needle.length();i++){
      char c1=haystack.charAt(i);
      int j;
      for(j=0;j<needle.length();j++){
        if(haystack.charAt(i+j)!=needle.charAt(j))
          break;
      }
      if(needle.length()==j)
        return i;
    }
    return -1;
  }

  public static int strstr(String X, String Y)
  {
    // if X is null or if X's length is less than that of Y's
    if (X == null || Y.length() > X.length()) {
      return -1;
    }

    // if Y is null or is empty
    if (Y == null || Y.length() == 0) {
      return 0;
    }

    for (int i = 0; i <= X.length() - Y.length(); i++)
    {
      int j;
      for (j = 0; j < Y.length(); j++) {
        if (Y.charAt(j) != X.charAt(i + j)) {
          break;
        }
      }

      if (j == Y.length()) {
        return i;
      }
    }

    return -1;
  }
}
