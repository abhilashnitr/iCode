package LeetCode.Easy.April27;

public class LengthofLastWord {
  public int lengthOfLastWord(String s) {
    if(s == null)
      return 0;

    String[] parts = s.trim().split(" ");
    if(parts.length == 0)
      return 0;
    else
      return parts[parts.length - 1].length();
  }
}
