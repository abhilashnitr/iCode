package main.FAANG.SlidingWindow;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String st="abcabcbb";
        LongestSubstringWithoutRepeatingCharacters s=new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstring(st));
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int[] cache = new int[256];
        for (int end = 0, start = 0; end < s.length(); end++) {
            //move start point only if current char (char at end) is already present move start
            start = (cache[s.charAt(end)] > 0) ? Math.max(start, cache[s.charAt(end)]) : start;
            cache[s.charAt(end)] = end + 1;
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
