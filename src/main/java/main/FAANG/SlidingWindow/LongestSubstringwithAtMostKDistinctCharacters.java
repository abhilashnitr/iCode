package main.FAANG.SlidingWindow;

public class LongestSubstringwithAtMostKDistinctCharacters {
//Given a string, find the length of the longest substring T that contains at most k distinct characters.

    public static void main(String[] args) {
        LongestSubstringwithAtMostKDistinctCharacters test=new LongestSubstringwithAtMostKDistinctCharacters();
        System.out.println(test.lengthOfLongestSubstringKDistinct("caaabbdefggg",2));
    }
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];     // there are 256 ASCII characters in the world

        int i = 0;  // i will be behind j
        int distinctNumCount = 0;
        int res = 0;

        int j=0;
        while (j < s.length()) {
            if (count[s.charAt(j)]++ == 0) {    // if count[s.charAt(j)] == 0, we know that it is a distinct character
                distinctNumCount++;
            }
            while (distinctNumCount > k && i < s.length()) {     // sliding window
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0){
                    distinctNumCount--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
