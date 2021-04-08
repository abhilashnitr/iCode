package main.FAANG.TreeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {

  public static void main (String[] args) {
    ArrayList<String> strs=new ArrayList<>();

    strs.add("doghj");
    strs.add("domuk");
    strs.add("doebra");
    LongestCommonPrefix pr =new LongestCommonPrefix();
    System.out.println(pr.prefix(strs));
  }

  String prefix( ArrayList<String> strs){

    TrieNode root = new TrieNode();

    for (String s : strs) {
      insert(root, s);
    }

    String s1=strs.get(0);
    int count=strs.size();

    StringBuilder s=new StringBuilder();

    for(char c:s1.toCharArray()){
      if(root.children.get(c).count==count){
        s.append(c);
        root=root.children.get(c);
      }else
        break;
    }

    return s==null?"No Prefix":s.toString();
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
