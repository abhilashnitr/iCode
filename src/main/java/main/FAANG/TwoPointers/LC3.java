package main.FAANG.TwoPointers;

import java.util.HashMap;

public class LC3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int end=0, start=0; end<s.length(); ++end){
            if (map.containsKey(s.charAt(end))){
                start = Math.max(start,map.get(s.charAt(end))+1);
            }
            map.put(s.charAt(end),end);
            max = Math.max(max,end-start+1);
        }
        return max;
    }


    //Here is the same algo with int[256] rather than HashMap. Faster than map and shorter code.
    public int lengthOfLongestSubstring2(String s) {
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


    // time - O(n^2)
    // space - O(256)
    public static int longestUniqueSubsttr(String str)
    {
        int n = str.length();

        // Result
        int res = 0;

        for(int i = 0; i < n; i++)
        {

            // Note : Default values in visited are false
            boolean[] visited = new boolean[256];

            for(int j = i; j < n; j++)
            {

                // If current character is visited
                // Break the loop
                if (visited[str.charAt(j)] == true)
                    break;

                    // Else update the result if
                    // this window is larger, and mark
                    // current character as visited.
                else
                {
                    res = Math.max(res, j - i + 1);
                    visited[str.charAt(j)] = true;
                }
            }

            // Remove the first character of previous
            // window
            visited[str.charAt(i)] = false;
        }
        return res;
    }
}
