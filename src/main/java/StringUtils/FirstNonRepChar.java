package StringUtils;

public class FirstNonRepChar {
  static final int NO_OF_CHARS = 256;
  static char count[] = new char[NO_OF_CHARS];

  public int firstUniqChar(String str) {

    for (int i = 0; i < str.length();  i++)
      count[str.charAt(i)]++;
    int index = -1, i;

    for (i = 0; i < str.length();  i++)
    {
      if (count[str.charAt(i)] == 1)
      {
        index = i;
        break;
      }
    }

    return index;

  }

}
