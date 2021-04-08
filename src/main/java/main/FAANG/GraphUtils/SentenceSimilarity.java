package main.FAANG.GraphUtils;

import java.util.*;

public class SentenceSimilarity {

    public static void main(String[] args) {
        String[] list1={"great", "acting", "skills"};
        String[] list2={"fine", "drama", "talent"};
        String[][] lists={{"great", "good"},{"fine", "good"},{"acting","drama"},{"skills","talent"}};

        SentenceSimilarity sentenceSimilarity = new SentenceSimilarity();
        System.out.println(sentenceSimilarity.areSentencesSimilarTwoUnionFind(list1,list2,lists));
    }

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;

        Map<String, Set<String>> map = new HashMap<>();
        for (String[] p : pairs) {
            map.putIfAbsent(p[0], new HashSet<>());
            map.putIfAbsent(p[1], new HashSet<>());
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!map.containsKey(words1[i])) return false;
            if (!map.get(words1[i]).contains(words2[i])) return false;
        }

        return true;
    }


    //Similarity 2
    //The idea is simple:

    //Build the graph according to the similar word pairs. Each word is a graph node.
    //For each word in words1, we do DFS search to see if the corresponding word is existing in words2.

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, Set<String>> graph = new HashMap<>();
        for (String[] p : pairs) {
            graph.putIfAbsent(p[0], new HashSet<>());
            graph.putIfAbsent(p[1], new HashSet<>());
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;
            if (!graph.containsKey(words1[i])) return false;
            if (!dfs(graph, words1[i], words2[i], new HashSet<>())) return false;
        }

        return true;
    }

    private boolean dfs(Map<String, Set<String>> graph, String source, String target, Set<String> visited) {
        if (graph.get(source).contains(target)) return true;

        if (visited.add(source)) {
            for (String next : graph.get(source)) {
                if (!visited.contains(next) && dfs(graph, next, target, visited))
                    return true;
            }
        }
        return false;
    }


    //Simillar two using Union Find
    public boolean areSentencesSimilarTwoUnionFind(String[] words1, String[] words2, String[][] pairs) {

        if(words1.length!=words2.length)
            return false;

        Map<String,String> map = new HashMap<String,String>();

        for(String[] pair : pairs){

            String word1 = pair[0];
            String word2 = pair[1];

            if(!map.containsKey(word1))
                map.put(word1,word1);
            if(!map.containsKey(word2))
                map.put(word2,word2);

            setParent(map,word1,word2);

        }

        for(int i=0;i<words1.length;i++){

            String word1 = words1[i];
            String word2 = words2[i];

            String parent1 = getParent(word1,map);
            String parent2 = getParent(word2,map);

            if(!parent1.equals(parent2))
                return false;

        }
        return true;


    }

    public String getParent(String word,Map<String,String> map){

        if(!map.containsKey(word))
            return word;

        while(word!=map.get(word))
            word = map.get(word);
        return word;

    }

    public void setParent(Map<String,String> map,String word1,String word2){

        String p1 = getParent(word1,map);
        String p2 = getParent(word2,map);

        map.put(p1,p2);

    }
}
