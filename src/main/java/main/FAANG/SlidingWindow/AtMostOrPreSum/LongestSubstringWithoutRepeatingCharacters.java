package main.FAANG.SlidingWindow.AtMostOrPreSum;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String st="   ";
        LongestSubstringWithoutRepeatingCharacters s=new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(s.lengthOfLongestSubstring(st));
    }

    public int lengthOfLongestSubstring(String s) {



//        int[] cache =new int[256];
//        int start=0;
//        int res=0;
//        for(int end=0;end<s.length();end++){
//            char ch=s.charAt(end);
//            if(cache[ch-'a']>0)
//                start=Math.max(start,cache[ch-'a']);
//            cache[ch-'a']=end+1;
//            res=Math.max(res,end-start+1);
//
//
//        }
//        return res;

        int result = 0;
        int[] cache = new int[256];
        for (int end = 0, start = 0; end < s.length(); end++) {
            //move start point only if current char (char at end) is already present move start
            start = (cache[s.charAt(end)] > 0) ? Math.max(start, cache[s.charAt(end)]) : start;
            cache[s.charAt(end)] = end + 1;
            result = Math.max(result, end - start + 1);
        }
        return result;
    }

    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
    public int lengthOfLongestSubstring3(String s) {
        if(s.length()<=1)
            return s.length();

        int[] dp = new int[256];

        int i=0;
        int j=0;
        int ans=0;

        while(j<s.length()){
            if(dp[s.charAt(j)]>0){
                i=Math.max(i,dp[s.charAt(j)]);
            }
            dp[s.charAt(j)]=j+1;
            j++;
            ans=Math.max(ans,j-i);
        }
        return ans;
    }
}
