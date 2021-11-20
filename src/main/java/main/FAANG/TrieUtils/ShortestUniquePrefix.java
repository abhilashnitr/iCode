package main.FAANG.TrieUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShortestUniquePrefix {

  public static void main (String[] args) {
    ArrayList<String> strs=new ArrayList<>();
    ShortestUniquePrefix pr=new ShortestUniquePrefix();
    strs.add("doghj");
    strs.add("domuk");
    strs.add("zebra");
    ArrayList<String> prefixList=pr.prefix(strs);
    prefixList.forEach(System.out::println);
  }
  public ArrayList<String> prefix(ArrayList<String> a) {
    TrieNode root = new TrieNode();

    for (String s : a) {
      insert(root, s);
    }

    ArrayList<String> prefixes = new ArrayList<>();
    for (String s : a) {
      prefixes.add(findPrefix(root, s));
    }

    return prefixes;
  }

  String findPrefix(TrieNode root, String s) {
    TrieNode node = root;
    char[] chars = s.toCharArray();
    int i = 0;

    StringBuilder prefix = new StringBuilder();
    while (true) {
      char ch = chars[i++];

      prefix.append(ch);
      node = node.children.get(ch);

      if (node.count == 1) {
        return prefix.toString();
      }
    }
  }

  void insert(TrieNode root, String s) {
    TrieNode node = root;

    for (Character ch : s.toCharArray()) {
      node = node.children.computeIfAbsent(ch, k -> new TrieNode());
      node.count++;
    }
  }


  class TrieNode {
    int count = 0;
    Map<Character, TrieNode> children = new HashMap<>();
  }


}
