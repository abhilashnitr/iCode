package main.StackQueueUtils;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {

  public static void main(String[] args) {

    LFUCache cache = new LFUCache( 2 /* capacity */ );
    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);      // returns 1
    cache.get(2);      // returns 2
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.get(3);       // returns 3.
    cache.put(4, 4);    // evicts key 1.
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4
  }
  HashMap<Integer,Integer> values;
  HashMap<Integer,Integer> counts;
  HashMap<Integer, LinkedHashSet<Integer>> frequencyList;
  int min = -1;
  int capacity;
  public LFUCache(int capacity) {
    this.capacity = capacity;
    values = new HashMap<>();
    counts = new HashMap<>();
    frequencyList = new HashMap<>();
    frequencyList.put(1, new LinkedHashSet<>());
  }

  public int get(int key) {
    if(!values.containsKey(key)){
      System.out.println("Key accessed: "+-1);
      return -1;
    }

    int count = counts.get(key);
    counts.put(key,count + 1);
    frequencyList.get(count).remove(key);

    // when current min does not have any data, next one would be the min
    if (count == min && frequencyList.get(count).size() == 0){
      min++;
    }

    if(!frequencyList.containsKey(count + 1)) {
      frequencyList.put(count + 1,new LinkedHashSet<>());
    }
    frequencyList.get(count + 1).add(key);
    System.out.println("Key accessed: "+values.get(key));
    return values.get(key);
  }

  public void put(int key, int value) {
    if(capacity <= 0)
      return;
    if(values.containsKey(key)) {
      values.put(key,value);
      get(key);
      return;
    } else if(values.size() == capacity) {
      int evictKey = frequencyList.get(min).iterator().next();
      System.out.println("key evicted: "+evictKey);
      frequencyList.get(min).remove(evictKey);
      values.remove(evictKey);
      counts.remove(evictKey);
    }
    values.put(key,value);
    counts.put(key, 1);
    min = 1;
    frequencyList.get(1).add(key);
  }
}
