package HeapUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public  class Util
{
// A Trie node
public static class Trie
{
  // count and key will be set only for leaf nodes
  // key stores the string and count stores its frequency so far
  int count = 0;
  String key = null;

  // each node stores a map to its child nodes
  Map<Character, Trie> character = new HashMap<>();;
};

// A max-heap node
public static class Node implements Comparable
{
  String key;
  int count;

  // constructor
  Node(String key, int count) {
    this.key = key;
    this.count = count;
  }

  @Override
  public int compareTo(Object o) {
    Node node = (Node)o;
    return count - node.count;
  }
};


  // Iterative function to insert a string in Trie.
  private static void insert(Trie head, String str)
  {
    // start from root node
    Trie curr = head;

    for (int i = 0; i < str.length(); i++)
    {
      // create a new node if path doesn't exists
      if (!curr.character.containsKey(str.charAt(i))) {
        curr.character.put(str.charAt(i), new Trie());
      }

      // go to next node
      curr = curr.character.get(str.charAt(i));
    }

    // store key and its count in leaf nodes
    curr.key = str;
    curr.count += 1;
  }

  // Function to perform pre-order traversal of Trie and insert
  // each distinct key along with its count in max-heap
  private static void preorder(Trie curr, PriorityQueue<Node> pq)
  {
    // base condition
    if (curr == null) {
      return;
    }

    for (Map.Entry<Character, Trie> entry: curr.character.entrySet())
    {
      // if leaf node is reached (leaf node have non-zero count),
      // push key with its frequency in max-heap
      if (entry.getValue().count != 0) {
        pq.add(new Node(entry.getValue().key,
            entry.getValue().count));
      }

      // recur for current node children
      preorder(entry.getValue(), pq);
    }
  }

  // Function to find first k-maximum occurring words in given
  // list of strings
  public static void findKfrequentWords(String[] dict, int k)
  {
    Trie head = new Trie();

    // insert all keys into trie and maintain each key
    // frequency in trie leaf nodes
    for (String word: dict) {
      insert(head, word);
    }

    // create an empty max-heap
    PriorityQueue<Node> pq = new PriorityQueue<>(
        Comparator.reverseOrder()
    );

    // perform pre-order traversal of given Trie and push each
    // unique key with its frequency in max-heap
    preorder(head, pq);

    // do till max-heap is not empty or k keys are not printed
    while (k-- > 0 && !pq.isEmpty())
    {
      // extract the maximum node from the max-heap
      Node max = pq.poll();

      // print the maximum occurring element with its count
      System.out.println(max.key + " occurs " + max.count + " times");
    }
  }

  // Find first k maximum occurring words in given set of strings
  public static void main (String[] args)
  {
    // given set of keys
    String[] dict =
        {
            "code", "coder", "coding", "codable", "codec", "codecs",
            "coded", "codeless", "codec", "codecs", "codependence",
            "codex", "codify", "codependents", "codes", "code",
            "coder", "codesign", "codec", "codeveloper", "codrive",
            "codec", "codecs", "codiscovered"
        };

    int k = 4;

    findKfrequentWords(dict, k);
  }
}
