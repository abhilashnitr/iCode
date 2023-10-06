package main.FAANG.SlidingWindow;

//Given a string s and an integer k, return the length of the longest substring of s such that the frequency
// of each character in this substring is greater than or equal to k.


//https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
public class LongestSubstringwithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) {
            return 0;
        }

        int max = 0; // length of longest substring T
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {    // numUniqueTarget = target number of unique letters in substring T
            max = Math.max(max, longestSubstringWithTargetUniqueLetters(s, k, numUniqueTarget));
        }

        return max;
    }

    // return the length of longest substring T with target number of unique letters
    private int longestSubstringWithTargetUniqueLetters(String s, int k, int numUniqueTarget) {
        int[] map = new int[26]; // letter -> freq
        int numUnique = 0;   // # of unique letters
        int numAtLeastK = 0; // # of unique letters with occurrence >= k
        int max = 0; // length of longest substring T with target number of unique letters

        // slding window
        // if numUnique <= numUniqueTarget, expand right end, update numUnique & numAtLeastK
        // if numUnique > numUniqueTarget, shrink left end
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right); // new rightmost char
            if (map[rChar - 'a'] == 0) {
                numUnique++;
            }
            map[rChar - 'a']++;
            if (map[rChar - 'a'] == k) {
                numAtLeastK++;
            }

            while (numUnique > numUniqueTarget) {
                char lChar = s.charAt(left); // leftmost char in current window
                left++;
                if (map[lChar - 'a'] == 1) {
                    numUnique--;
                }
                if (map[lChar - 'a'] == k) {
                    numAtLeastK--;
                }
                map[lChar - 'a']--;
            }

            // now numUnique <= numUniqueTarget
            if (numUnique == numUniqueTarget && numUnique == numAtLeastK) {
                max = Math.max(max, right - left + 1);
            }
        }

        return max;
    }
}
