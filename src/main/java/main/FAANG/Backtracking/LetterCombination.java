package main.FAANG.Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {
    public static void main(String[] args) {

        Map<Character, char[]> letterMap=getLettersMap();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        letterCombination(letterMap,result,sb,"234");
        System.out.println(result);
    }

    private static void letterCombination(Map<Character,char[]> letterMap, List<String> result, StringBuilder sb, String digits) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for(char c:letterMap.get(digits.charAt(sb.length()))){
            sb.append(c);
            letterCombination(letterMap,result,sb,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    private static Map<Character, char[]> getLettersMap() {
        Map<Character, char[]> lettersMap = new HashMap<>();
        lettersMap.put('0', new char[]{});
        lettersMap.put('1', new char[]{});
        lettersMap.put('2', new char[]{'a', 'b', 'c'});
        lettersMap.put('3', new char[]{'d', 'e', 'f'});
        lettersMap.put('4', new char[]{'g', 'h', 'i'});
        lettersMap.put('5', new char[]{'j', 'k', 'l'});
        lettersMap.put('6', new char[]{'m', 'n', 'o'});
        lettersMap.put('7', new char[]{'p', 'q', 'r', 's'});
        lettersMap.put('8', new char[]{'t', 'u', 'v'});
        lettersMap.put('9', new char[]{'w', 'x', 'y', 'z'});

        return lettersMap;
    }
}
