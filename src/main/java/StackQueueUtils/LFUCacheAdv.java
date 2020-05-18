package StackQueueUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class LFUCacheAdv {
  private int capacity;
  private HashMap<Integer, Integer> cache;
  private TreeMap<Integer, LinkedList<Integer>> freqMap;

  public LFUCacheAdv(int capacity) {
    this.capacity = (capacity < 0) ? 0 : capacity;
    cache = new HashMap<>();
    freqMap = new TreeMap<>();
  }

  public int get(int key) {
    if (capacity == 0 && cache.size() == 0)
      return -1;

    if (cache.containsKey(key)) {
      incrementFrequency(key);
      return cache.get(key);
    } else {
      return -1;
    }
  }

  private void incrementFrequency(int key) {
    int nFr = getPrevFrequency(key);
    setFrequency(nFr + 1, key);
  }

  public void put(int key, int value) {
    if (capacity == 0 || value < 0) {
      return;
    }

    if (this.get(key) < 0) {
      // "get" operation incremets a frequency value for a key if it's in a cache

      // two branches if a key is not present in a cache
      if (cache.size() < capacity) { // there is enought space for a new key
        setFrequency(1, key);

      } else { // find an key to be evicted (the least frequently used item)
        Map.Entry<Integer, LinkedList<Integer>> minEntry = freqMap.firstEntry();
        // a key in minEntry is the mimimum frequency
        LinkedList<Integer> minList = minEntry.getValue();
        cache.remove(minList.removeFirst()); // remove the least recently used key from a list and a cache
        setFrequency(1, key);
        if (minList.isEmpty()) { // no keys left in a minEntry
          freqMap.remove(minEntry.getKey());
        }
      }
    }
    cache.put(key, value); // executed for all cases
  }

  // return a frequency value for a given key and remove a given key from a
  // frequency map
  private int getPrevFrequency(int key) {
    for (Map.Entry<Integer, LinkedList<Integer>> entry : freqMap.entrySet()) {
      LinkedList<Integer> list = entry.getValue(); // list of keys with the same frequency
      // check a list wheather it contains a given key
      if (list.contains((Integer) key)) {
        int nFr = entry.getKey(); // a frequencyvalue for a given key (return value)
        removeKey(key, list, nFr); // since a frequencyvalue for a key will be increased
        return nFr;
      }
    }
    return 0;
  }

  // remove a key fron a list;
  // remove an entry from a frequence map if only one key was in a list
  void removeKey(int key, LinkedList<Integer> list, int nFr) {
    list.remove((Integer) key);
    if (list.isEmpty()) {
      freqMap.remove(nFr);
    }
  }

  // add a key to a list associated with a frequency value
  private void setFrequency(int nFr, int key) {
    if (!freqMap.containsKey(nFr)) {
      freqMap.put(nFr, new LinkedList<>());
    }
    freqMap.get(nFr).addLast((Integer) key);
  }
}


/*
HashMap<Integer, Integer> cache
is the cache itself. It doesn't matter what is the order for saving elements
TreeMap<Integer, LinkedList> freqMap
is the auxiliary data structure that keeps how frequently the key is used both get and put operations.

freqMap's key is a frequency of accessing operations applied to keys from a cache.
By default, TreeMap preserves ascending order of keys. So when we need the least frequently used item in LFUCache, invoking a method firstEntry gives us the entry with the least frequency
A frequency is only positive value.

freqMap's value is a list of keys from a cache that have the same frequency.
It works like a queue. New values are added to the end of a list. When there are two or more keys that have the same frequency, the least recently used key is the first.
if key (frequency) is mapping to an empty list, this entry will be removed.

Some examples how cache and freqMap are changing while LFUCache is invoked alternately by get and put

lfuCache = new LFUCache(5);
lfuCache.put(1,1);
lfuCache.put(2,2);
lfuCache.put(3,3);
// cache = {1 -> 1, 2-> 2, 3 -> 3}
// frMap = {1 -> [1, 2, 3]}

//changes the value associated with a key
lfuCache.put(1,10);
lfuCache.get(1);
lfuCache.put(3,30);
// cache = {1 -> 10, 2-> 2, 3 -> 30}
// frMap = {1 -> [2], 2 -> [3], 3 -> [1]}

//puts new keys when size < capacity
lfuCache.put(4, 4);
lfuCache.put(5, 5);
// cache = {1 -> 10, 2-> 2, 3 -> 30, 4 -> 4, 5 -> 5}
// frMap = {1 -> [2, 4, 5], 2 -> [3], 3 -> [1]}

//inserts new key when size == capacity
lfuCache.put(6, 6); //evicts 2
// cache = {1 -> 10, 3 -> 30, 4 -> 4, 5 -> 5, 6 -> 6}
// frMap = {1 -> [4, 5, 6], 2 -> [3], 3 -> [1]}
 */
