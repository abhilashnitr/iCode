package main.StringUtils;

public class CompareVersion {

    public static void main(String[] args)
    {
      String version1 = "3.0";
      String version2 = "3.0.7";

      if (versionCompare(version1, version2) < 0)
        System.out.println(version1 +" is smaller");
      else if (versionCompare(version1, version2) > 0)
        System.out.println(version2 +" is smaller");
      else
        System.out.println("Both version are equal");
    }

  public static int versionCompare(String v1, String v2) {
    int vnum1 = 0, vnum2 = 0;

    // loop untill both String are processed
    for (int i = 0, j = 0; (i < v1.length() || j < v2.length()); )
    {
      // storing numeric part of version 1 in vnum1
      while (i < v1.length() && v1.charAt(i) != '.')
      {
        vnum1 = vnum1 * 10 + (v1.charAt(i) - '0');
        i++;
      }

      // storing numeric part of version 2 in vnum2
      while (j < v2.length() && v2.charAt(j) != '.')
      {
        vnum2 = vnum2 * 10 + (v2.charAt(j) - '0');
        j++;
      }

      if (vnum1 > vnum2)
        return 1;
      if (vnum2 > vnum1)
        return -1;

      // if equal, reset variables and go for next numeric
      // part
      vnum1 = vnum2 = 0;
      i++;
      j++;
    }
    return 0;
  }
}
