package main.FAANG.TwoPointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//763. Partition Labels
//A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so
// that each letter appears in at most one part, and return a list of integers representing the size of these parts.
//Input: S = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
public class LC763 {
    public static void main(String[] args) {
        String s="ababcbacadefegdehijhklij";
        LC763 lc763=new LC763();
        System.out.println(lc763.partitionLabels2(s));
    }

    //traverse the string record the last index of each char.
    //using pointer to record end of the current sub string.
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        int[] map = new int[26];  // record the last index of the each char

        for(int i = 0; i < S.length(); i++){
            map[S.charAt(i)-'a'] = i;
        }
        // record the end index of the current sub string
        int last = 0;
        int start = 0;
        for(int i = 0; i < S.length(); i++){
            last = Math.max(last, map[S.charAt(i)-'a']);
            if(last == i){
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        return list;
    }

    public List<Integer> partitionLabels2(String S) {
        int[] charCount = new int[26];
        int st = 0;
        char currentChar;
        Set<Character> currentWindow = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(char ch : S.toCharArray()) {
            charCount[ch - 'a']++;
        }

        for(int i = 0; i < S.length(); i++) {
            currentChar = S.charAt(i);
            currentWindow.add(currentChar);

            if(--charCount[currentChar - 'a'] == 0) {
                currentWindow.remove(currentChar);
            }

            if(currentWindow.size() == 0) {
                result.add(i - st + 1);
                st = i + 1;
            }
        }

        return result;

    }


}
