package main.FAANG.GraphUtils;

import java.util.*;

public class SentenceSimilarity {

    public static void main(String[] args) {
        String[] list1={"great", "acting", "skills"};
        String[] list2={"fine", "drama", "talent"};
        String[][] lists={{"great", "fine"},{"fine", "good"},{"acting","drama"},{"skills","talent"}};

        SentenceSimilarity sentenceSimilarity = new SentenceSimilarity();
        System.out.println(sentenceSimilarity.areSentencesSimilar(list1,list2,lists));
        System.out.println(sentenceSimilarity.areSentencesSimilarTwo(list1,list2,lists));

    }

    //Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs,
    //determine if two sentences are similar.
    //For example, "great acting skills" and "fine drama talent" are similar, if the similar word pairs
    //are pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].
    //Note that the similarity relation is not transitive. For example, if "great" and "fine" are similar, and
    //"fine" and "good" are similar, "great" and "good" are not necessarily similar.
    //However, similarity is symmetric. For example, "great" and "fine" being similar is the same as "fine"
    //and "great" being similar.
    //Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"],
    //pairs = [] are similar, even though there are no specified similar word pairs.
    //Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"]
    //can never be similar to words2 = ["doubleplus","good"].

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
    //For example,
    // words1 = ["great", "acting", "skills"] and
    // words2 = ["fine", "drama", "talent"] are similar,
    // if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
    //Note that the similarity relationistransitive. For example, if "great" and "good" are similar, and "fine" and
    // "good" are similar, then "great" and "fine" are similar.

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

        while(!word.equals(map.get(word)))
            word = map.get(word);
        return word;

    }

    public void setParent(Map<String,String> map,String word1,String word2){

        String p1 = getParent(word1,map);
        String p2 = getParent(word2,map);

        map.put(p1,p2);

    }
}
