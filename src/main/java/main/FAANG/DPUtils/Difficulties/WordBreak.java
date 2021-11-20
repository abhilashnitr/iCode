package main.FAANG.DPUtils.Difficulties;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s="leetcode";
        List<String> list= Arrays.asList("leet","code");
        System.out.println(wordBreak.wordBreak(s,list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int index = 0;
        int n = s.length();
        if (n == 0 || wordDict.size() == 0)
            return false;
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;
        for (index = 0; index < s.length(); index++) {
            if (!dp[index])
                continue;
            for (String word : wordDict) {
                int h = index + word.length();
                if (h <= n && s.substring(index, h).equals(word))
                    dp[h] = true;
            }
        }
        return dp[n];
    }


    public boolean wordBreak2(String s, List<String> wordDict) {
        // put all words into a hashset
        Set<String> set = new HashSet<>(wordDict);
        return wb(s, set);
    }
    private boolean wb(String s, Set<String> set) {
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 1; i <= len; ++i) {
            if (set.contains(s.substring(0, i)) && wb(s.substring(i), set)) {
                return true;
            }
        }
        return false;
    }
}
