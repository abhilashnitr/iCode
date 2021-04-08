package main.FAANG.SlidingWindow;

import java.util.Arrays;
import java.util.HashSet;

public class FindK_LengthSubstringsWithNoRepeatedCharacters {

    public int numKLenSubstrNoRepeats(String S, int K) {
        HashSet<Character> cur = new HashSet<>();
        int res = 0, start = 0;
        for (int end = 0; end < S.length(); ++end) {
            while (cur.contains(S.charAt(end))) {
                cur.remove(S.charAt(start++));
            }
            cur.add(S.charAt(end));
            res += end - start + 1 >= K ? 1 : 0;
        }
        return res;
    }

    public int numKLenSubstrNoRepeats2(String S, int K) {
        if (K <= 0 || S == null || S.length() < K) return 0;
        int[] m = new int[26];
        Arrays.fill(m, -1);
        int i = 0;
        int res = 0;
        for (int j = 0; j < S.length(); j++) {
            char c = S.charAt(j);
            if (m[c-'a'] != -1) {  // if duplicate exist , shrink the window
                i = Math.max(m[c-'a']+1, i);
            }
            m[c-'a'] = j;
            if (j-i+1 == K) {
                res++;
                i++;
            }
        }
        return res;
    }
}
