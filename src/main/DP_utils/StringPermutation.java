package main.DP_utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringPermutation {

    public static void permutation(String str){
        HashMap<Character, Integer> map=new HashMap<>();
        for(Character c:str.toCharArray()){
            if(map.containsKey(c)){
                int x=map.get(c);
                map.put(c,x+1);
            }
            else {
                map.put(c,1);
            }
        }
        Character[] Char=new Character[map.size()];
        Integer[] count=new Integer[map.size()];
        int i=0;
        for(Character c:map.keySet()){
            Char[i]=c;
            count[i]=map.get(c);
            i++;
        }
        char[] result=new char[str.length()];
        List<String> resultList = new ArrayList<>();
        permutationUtil(Char,count,0,result,resultList);
        System.out.println(resultList);

    }

    private static void permutationUtil(Character[] aChar, Integer[] count, int level, char[] result, List<String> resultList) {
        if(level==result.length){
            resultList.add(new String(result));
            return;
        }
        for(int i=0;i<count.length;i++){
            if(count[i]==0)
                continue;
            result[level]=aChar[i];
            count[i]--;
            permutationUtil(aChar,count,level+1,result,resultList);
            count[i]++;
        }
    }
    public static void main(String[] args) {
        String s="abca";
        permutation(s);
    }
}
