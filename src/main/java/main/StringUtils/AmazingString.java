package main.StringUtils;

//print all substrings which start with vowel.
public class AmazingString {

  public int solve(String A) {
    int x=0;
    for (int i = 0; i <A.length(); i++) {
      if(isVowel(A.charAt(i))){
        x=x+A.length()-i;
      }
    }
    return x%10003;
  }

  public static boolean isVowel(char a){
    if(a=='A' || a=='E' || a=='I'|| a=='O'|| a=='U'|| a=='a'|| a=='e'|| a=='i'|| a=='o'|| a=='u')return true;
    return false;
  }
}
