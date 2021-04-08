package main.DP_utils;

import java.util.Arrays;
import java.util.List;

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
}
