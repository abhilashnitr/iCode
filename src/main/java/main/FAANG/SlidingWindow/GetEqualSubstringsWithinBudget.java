package main.FAANG.SlidingWindow;

/*
You are given two strings s and t of the same length. You want to change s to t. Changing the i-th character of s to i-th character of t costs |s[i] - t[i]| that is, the absolute difference between the ASCII values of the characters.

You are also given an integer maxCost.

Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of twith a cost less than or equal to maxCost.

If there is no substring from s that can be changed to its corresponding substring from t, return 0.
*/
public class GetEqualSubstringsWithinBudget {
    public int equalSubstring(String s, String t, int k) {
        int n = s.length(), i = 0, j;
        for (j = 0; j < n; ++j) {
            k -= Math.abs(s.charAt(j) - t.charAt(j));
            if (k < 0) {
                k += Math.abs(s.charAt(i) - t.charAt(i));
                ++i;
            }
        }
        return j - i;
    }

    //Time Complexity: O(N) where N is the length of strings s, t
}
