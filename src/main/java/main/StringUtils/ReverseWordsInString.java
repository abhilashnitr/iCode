package main.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInString {
  public String reverseWords(String s) {
    String[] split = s.trim().split("\\s+");
    StringBuilder sb = new StringBuilder();
    for(int i = split.length - 1; i >= 0; i--){
      sb.append(" "+split[i]);
    }
    return sb.toString().replaceFirst(" ","");
  }

  public String reverseWords2(String s) {
    StringBuilder sb = new StringBuilder();
    String[] array = s.trim().split(" ");
    Arrays.stream(array).forEach(item ->{
      if(!item.trim().equals("")){
        sb.insert(0,item.trim()+" ");
      }
    });
    return sb.toString().trim();
  }

  public String reverseWords3(String s) {
    List<String> token = Arrays.asList(s.trim().split("\\s+"));
    Collections.reverse(token);
    return String.join(" ", token);
  }
}
