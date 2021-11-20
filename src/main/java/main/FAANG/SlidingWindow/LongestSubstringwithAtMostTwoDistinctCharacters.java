package main.FAANG.SlidingWindow;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

    public static void main(String[] args) {
        LongestSubstringwithAtMostTwoDistinctCharacters test=new LongestSubstringwithAtMostTwoDistinctCharacters();
        System.out.println(test.lengthOfLongestSubstringKDistinct("caaabbdefggg",2));
    }
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, start = 0, res = 0;
        for (int end = 0; end < s.length(); end++) {
            if (count[s.charAt(end)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(start++)] > 0);
                num--;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        int[] count = new int[256];     // there are 256 ASCII characters in the world

        int i = 0;  // i will be behind j
        int num = 0;
        int res = 0;

        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) {    // if count[s.charAt(j)] == 0, we know that it is a distinct character
                num++;
            }
            while (num > k && i < s.length()) {     // sliding window
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0){
                    num--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
