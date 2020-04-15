package StringUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharInStream {

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

  public static void main(String[] args) {

    char[] stream = {'a', 'a', 'b', 'c', 'c', 'd', 'b', 'a', 'd'};

    printFirstNonRepeatingCharactersInStream(stream);

  }

}
