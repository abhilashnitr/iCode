package CoreJavaUtils.FunctionalInterface;

import java.util.function.Function;

public class FunctionDemo {

  static Function<String, String> shortName = (s) -> {
    if (null == s || s.length() == 0) return "Unknown";
    String[] splits = s.split(" ");
    String ret = splits[0];
    if (splits.length >= 2) ret += " " + splits[1].substring(0, 1) + ".";
    return ret;
  };

  public static void main(String... args) {
    System.out.println(shortName.apply("Kazi Mahbubur Rahman"));
    System.out.println(shortName.apply("Adam Smith"));
  }
}
