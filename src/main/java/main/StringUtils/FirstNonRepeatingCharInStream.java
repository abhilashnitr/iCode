package main.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharInStream {

  static final int NO_OF_CHARS = 256;
  static char count[] = new char[NO_OF_CHARS];

  public static void printFirstNonRepeatingCharactersInStream(char[] stream) {
    HashMap<Character, Integer> map = new HashMap<>();
    Queue<Character> q = new LinkedList<>();
    for(int i = 0; i < stream.length; i++) {
      map.put(stream[i], map.getOrDefault(stream[i], 0) + 1);
      if(map.get(stream[i]) == 1) {
        q.add(stream[i]);
      }
      while(!q.isEmpty()) {
        char c = q.peek();
        if(map.get(c) == 1) {
          break;
        } else {
          q.remove();
        }
      }
      if(q.isEmpty()) {
        System.out.print(-1 + " ");
      } else {
        System.out.print(q.peek() + " ");
      }
    }
  }

  private static int firstNonRepeating(String str) {

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

  public static void main(String[] args) {

    char[] stream = {'a', 'a', 'b', 'c', 'c', 'd', 'b', 'a', 'd'};

    printFirstNonRepeatingCharactersInStream(stream);

    String str = "geeksforeeks";
    int index =  firstNonRepeating(str);
    System.out.println(index == -1 ? "Either all characters are repeating or string " +
        "is empty" : "First non-repeating character is " +  str.charAt(index));

  }

}
