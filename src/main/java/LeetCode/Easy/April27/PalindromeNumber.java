package LeetCode.Easy.April27;

public class PalindromeNumber {
  public boolean isPalindrome(int num) {
    if(num<0)
      return false;
    int x=num;
    long reversed=0;
    while(num != 0) {
      int digit = num % 10;
      if((reversed * 10 + digit)>=Integer.MAX_VALUE)
        return false;
      reversed = reversed * 10 + digit;
      num /= 10;
    }
    return (int)reversed==x;
  }

}
