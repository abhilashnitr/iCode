package StringUtils;

public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while(i < j) {
      while(i < j && !isAlphanumeric(s.charAt(i))) i++;
      while(i < j && !isAlphanumeric(s.charAt(j))) j--;
      if(Character.toLowerCase(s.charAt(i++)) != Character.toLowerCase(s.charAt(j--))) {
        return false;
      }
    }
    return true;
  }

  private boolean isAlphanumeric(char c) {
    return Character.isLetter(c) || Character.isDigit(c);
  }

}
