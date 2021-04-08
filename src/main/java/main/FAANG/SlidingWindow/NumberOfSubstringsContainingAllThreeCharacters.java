package main.FAANG.SlidingWindow;

/*
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.
Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are
"abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
*/
public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String demo="abcabc";
        NumberOfSubstringsContainingAllThreeCharacters n=new NumberOfSubstringsContainingAllThreeCharacters();
        System.out.println(n.numberOfSubstrings(demo));
    }
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int ans = 0;
        for (int lo = -1, hi = 0; hi < s.length(); ++hi) {
            ++count[s.charAt(hi) - 'a'];
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans += s.length() - hi; // number of valid substrings all start from lo + 1, but end at hi, hi + 1, ..., s.length() - 1, respectively.
                --count[s.charAt(++lo) - 'a'];
            }
        }
        return ans;
    }
}

/*
Maintain a sliding window (lo, hi], where lower bound exclusively and upper bound inclusively;
Traverse string s, use upper bound hi to count the number of the 3 characters, a, b, & c; once the sliding window includes all of the 3, we find s.length() - hi substrings (lo, hi], (lo, hi + 1], ..., (lo, s.length() - 1];
Increase the lower bound lo by 1 (denote it as lo'), decrease the count accordingly, if the sliding window still includes all of the 3 characters, we count in substrings (lo', hi], (lo', hi + 1], ..., (lo', s.length() - 1];
Repeat 3 till the sliding window short of at least 1 of the 3 characters, go to step 2;
Repeat 2 - 4 till the end of the string s.
Time: O(n), space: O(1), where n = s.length().
*/
