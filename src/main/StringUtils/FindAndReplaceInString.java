package main.StringUtils;

import java.util.Arrays;

//S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
public class FindAndReplaceInString {

  public static void main(String[] args) {
    int[] indexes={0,2};
    String[] sources={"a","cd"};
    String[] targets={"eee","ffff"};
    String S="abcd";
    System.out.println(findReplaceString2(S,indexes,sources,targets));
  }

  public static String  findReplaceString2(String S, int[] indexes, String[] sources, String[] targets) {
    int N = S.length();
    int[] match = new int[N];
    Arrays.fill(match, -1);

    for (int i = 0; i < indexes.length; ++i) {
      int ix = indexes[i];
      if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
        match[ix] = i;
    }

    StringBuilder ans = new StringBuilder();
    int ix = 0;
    while (ix < N) {
      if (match[ix] >= 0) {
        ans.append(targets[match[ix]]);
        ix += sources[match[ix]].length();
      } else {
        ans.append(S.charAt(ix++));
      }
    }
    return ans.toString();
  }

  public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    StringBuilder res = new StringBuilder(S);
    int[] shift = new int[indexes.length];
    for (int i=0;i<indexes.length;i++) {
      if (checkValid(S, indexes[i], sources[i])) {
        int num = 0;
        for (int j=0;j<shift.length;j++) {
          if (indexes[j] < indexes[i]) {
            num += shift[j];
          }
        }
        res.replace(num + indexes[i], num + indexes[i] + sources[i].length(), targets[i]);
        shift[i] = targets[i].length() - sources[i].length();
      }
    }
    return res.toString();
  }

  public static boolean checkValid(String s, int index, String source) {
    int start = index;
    for (char i: source.toCharArray()) {
      if (i != s.charAt(start)) return false;
      start++;
    }
    return true;
  }

}
