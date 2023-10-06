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

    public int maxVowels2(String s, int k) {
        int vowel = 0;
        for(int i =0; i< k; i++)
            if(isVowel(s.charAt(i))) vowel++;
        int max = vowel;
        for(int i = k; i < s.length(); i++){
            if(isVowel(s.charAt(i))) vowel++;
            if(isVowel(s.charAt(i-k))) vowel--;
            max = Math.max(max, vowel);
        }
        return max;
    }
    private boolean isVowel(char c){
        if((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')) return true;
        return false;
    }
}
