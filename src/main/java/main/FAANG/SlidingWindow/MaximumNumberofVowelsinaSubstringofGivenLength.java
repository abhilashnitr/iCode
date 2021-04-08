package main.FAANG.SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given a string s and an integer k.
//
//Return the maximum number of vowel letters in any substring of s with length k.
//
//Vowel letters in English are (a, e, i, o, u).
public class MaximumNumberofVowelsinaSubstringofGivenLength {

    public int maxVowels(String s, int k) {
        int ans = 0;
         Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        //var vowels = Set.of('a', 'e', 'i', 'o', 'u'); // Java 11 Collection factory method, credit to @Sithis
        for (int i = 0, winCnt = 0; i < s.length(); ++i) {
            if (vowels.contains(s.charAt(i))) {
                ++winCnt;
            }
            if (i >= k && vowels.contains(s.charAt(i - k))) { // when size is more than k shrink the window
                --winCnt;
            }
            ans = Math.max(winCnt, ans);
        }
        return ans;
    }
}
