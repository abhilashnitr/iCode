package main.LeetCode.Easy.April27;

public class Sqrt {

  public static void main(String[] args) {
    System.out.println(mySqrt(17));
  }

  public static int mySqrt(int x) {
    if (x <=1) {
      return x;
    }
    long sqrt = x;
    while (sqrt*sqrt > x) {
      sqrt = (sqrt + x/sqrt) / 2;
    }
    return (int) sqrt;
  }
}
