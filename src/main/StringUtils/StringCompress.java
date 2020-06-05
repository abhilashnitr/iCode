package main.StringUtils;

public class StringCompress {
  public int compress(char[] chars) {
    int i = 0;
    int index = -1;
    while (i < chars.length) {
      int j = i;
      while (j < chars.length && chars[i] == chars[j]) {
        j++;
      }
      chars[++index] = chars[i];
      int count = (j - i);
      if (count > 1) {
        for (char c : String.valueOf(count).toCharArray()) {
          chars[++index] = c;
        }
      }

      i = j;
    }

    return ++index;
  }

}
