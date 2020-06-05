package main.LeetCode.Easy.April27;

public class LongestCommonPrefix {

  public String longestCommonPrefix(String[] strs) {
    if(strs.length==0)
      return "";
    if(strs.length==1)
      return strs[0];
    String prefix=strs[0];
    int k=0;
    int n=findMinLength(strs,strs.length);
    for(int i=0;i<n;i++){
      char ch=prefix.charAt(i);
      for(int j=1;j<strs.length;j++){
        if(ch!=strs[j].charAt(i))
          return prefix.substring(0,i);
      }
      k++;
    }
    return prefix.substring(0,k);
  }

  int findMinLength(String arr[], int n)
  {
    int min = arr[0].length();

    for (int i = 1; i < n; i++)
    {
      if (arr[i].length() < min)
      {
        min = arr[i].length();
      }
    }

    return (min);
  }

}
