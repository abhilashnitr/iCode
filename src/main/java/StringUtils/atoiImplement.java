package StringUtils;

public class atoiImplement {
  public static int atoi(String str)
  {
    if(str.length() == 0)
    {
      return -1;
    }
    int sign = 1;
    int res = 0;
    int i = 0;
    if(str.charAt(i)=='-')
    {
      sign = -1;
      i++;
    }
    for(; i < str.length(); i++)
    {
      if(Character.isDigit(str.charAt(i)) == false)
      {
        return -1;
      }
      res = res * 10 + Character.getNumericValue(str.charAt(i));
    }
    return sign * res;
  }

}
