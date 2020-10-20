package main.CoreJavaUtils;

import java.util.*;
import java.util.stream.IntStream;

public class LambdaUtils {
  public static void main(String[] args) {
//    Map<String, Integer> items = new HashMap<>();
//    items.put("A", 10);
//    items.put("B", 20);
//    items.put("C", 30);
//    items.put("D", 40);
//    items.put("E", 50);
//    items.put("F", 60);
//
//    items.forEach(((k,v)->System.out.println(k+" "+v)));

//    List<String> items = new ArrayList<>();
//    items.add("A");
//    items.add("B");
//    items.add("C");
//    items.add("D");
//    items.add("E");
//
//    items.stream().filter(s -> s.contains("B")).forEach(System.out::println);

    int[] nums = {4, 5, 2, 78, 45, 32, 15, 64, 1, 2, 4};
    System.out.println(IntStream.of(nums).min().getAsInt());
    IntStream.of(nums).min().ifPresent(min-> System.out.println(min));
    IntSummaryStatistics intSummaryStatistics=IntStream.of(nums).summaryStatistics();
    System.out.println(intSummaryStatistics.getMax()+" "+intSummaryStatistics.getMin());
    IntStream.of(nums)
              .distinct()
              .sorted()
              .limit(3)
              .forEach(System.out::println);


  }
}
