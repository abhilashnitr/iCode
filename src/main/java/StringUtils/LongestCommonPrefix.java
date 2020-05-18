package StringUtils;

public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] st={"geek","geerk","geekforGeek"};
    System.out.println(longestCommonPrefix(st));
  }
  public static String longestCommonPrefix(String[] strs) {
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

  static int findMinLength(String arr[], int n)
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
