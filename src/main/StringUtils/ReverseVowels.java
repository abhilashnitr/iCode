package main.StringUtils;

public class ReverseVowels {
  public String reverseVowels(String s) {
    char[] array = s.toCharArray();
    int start = 0;
    int end = s.length() -1;
    while(start < end){
      while(start < end && !isVowel(array[start])){
        start++;
      }

      while(start < end && !isVowel(array[end])){
        end--;
      }

      if(start<end){
        char temp = array[end];
        array[end] = array[start];
        array[start] = temp;
      }

      start++;
      end--;
    }

    return new String(array);
  }

  public boolean isVowel(char c){
    if(c == 'a') return true;
    if(c == 'e') return true;
    if(c == 'u') return true;
    if(c == 'o') return true;
    if(c == 'i') return true;
    if(c == 'A') return true;
    if(c == 'E') return true;
    if(c == 'U') return true;
    if(c == 'O') return true;
    if(c == 'I') return true;

    return false;
  }
}
