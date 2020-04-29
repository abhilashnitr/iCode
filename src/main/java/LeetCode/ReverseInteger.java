package LeetCode;

public class ReverseInteger {

  public static void main(String[] args) {

    System.out.println(reverse(121));
  }
  public static boolean reverse(int num) {
    long reversed=0;
    while(num != 0) {
      int digit = num % 10;
      if(((reversed * 10 + digit)>=Integer.MAX_VALUE)||((reversed * 10 + digit)<=Integer.MIN_VALUE))
        return false;
      reversed = reversed * 10 + digit;
      num /= 10;
    }

    return (int)reversed==num;
  }

}
