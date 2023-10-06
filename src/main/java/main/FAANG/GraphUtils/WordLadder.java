package main.FAANG.GraphUtils;

import java.util.*;

//Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
// transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
public class WordLadder {

    //Example 1:
    //
    //Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    //Output: 5
    //Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    //Example 2:
    //
    //Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    //Output: 0
    //Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

    //Time Complexity :- BigO(M^2 * N), where M is size of dequeued word & N is size of our word list
    //
    //Space Complexity :- BigO(M * N) where M is no. of character that we had in our string & N is the size of our wordList.

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q=new LinkedList<>();
        q.add(beginWord); q.add(null);
        HashSet<String> vis=new HashSet<>();
        vis.add(beginWord);
        int lvl=1;
        while(!q.isEmpty()) {
            String pop=q.poll();
            if(pop==null){
                lvl++;
                if(!q.isEmpty()) q.add(null);
            }else{
                char[] str=pop.toCharArray();
                for(int i=0;i<str.length; str[i]=pop.charAt(i), i++){
                    for(char a='a';a<='z';a++){
                        str[i]=a;
                        String neigh=new String(str);
                        if(set.contains(neigh) && !vis.contains(neigh)){
                            if(neigh.equals(endWord)) return lvl+1;
                            vis.add(neigh);
                            q.add(neigh);
                        }
                    }
                }
            }
        }
        return 0;
    }


    // Second Question , Print the shortest set of words
    //The first step BFS is quite important. I summarized three tricks
    //
    //Using a MAP to store the min ladder of each word, or use a SET to store the words visited in current ladder, when the current ladder was completed, delete the visited words from unvisited. That's why I have two similar solutions.
    //
    //Use Character iteration to find all possible paths. Do not compare one word to all the other words and check if they only differ by one character.
    //
    //One word is allowed to be inserted into the queue only ONCE.

    Map<String,List<String>> map;
    List<List> results;

    public List<List> findLadders(String start, String end, Set<String> dict) {

        results= new ArrayList<List>();
        if (dict.size() == 0)
            return results;

        int min=Integer.MAX_VALUE;

        Queue<String> queue= new ArrayDeque<String>();
        queue.add(start);

        map = new HashMap<String,List<String>>();

        Map<String,Integer> ladder = new HashMap<String,Integer>();
        for (String string:dict)
            ladder.put(string, Integer.MAX_VALUE);
        ladder.put(start, 0);

        dict.add(end);
        //BFS: Dijisktra search
        while (!queue.isEmpty()) {

            String word = queue.poll();

            int step = ladder.get(word)+1;//'step' indicates how many steps are needed to travel to one word.

            if (step>min) break;

            for (int i = 0; i < word.length(); i++){
                StringBuilder builder = new StringBuilder(word);
                for (char ch='a';  ch <= 'z'; ch++){
                    builder.setCharAt(i,ch);
                    String new_word=builder.toString();
                    if (ladder.containsKey(new_word)) {

                        if (step>ladder.get(new_word))//Check if it is the shortest path to one word.
                            continue;
                        else if (step<ladder.get(new_word)){
                            queue.add(new_word);
                            ladder.put(new_word, step);
                        }else;// It is a KEY line. If one word already appeared in one ladder,
                        // Do not insert the same word inside the queue twice. Otherwise it gets TLE.

                        if (map.containsKey(new_word)) //Build adjacent Graph
                            map.get(new_word).add(word);
                        else{
                            List<String> list= new LinkedList<String>();
                            list.add(word);
                            map.put(new_word,list);
                            //It is possible to write three lines in one:
                            //map.put(new_word,new LinkedList<String>(Arrays.asList(new String[]{word})));
                            //Which one is better?
                        }

                        if (new_word.equals(end))
                            min=step;

                    }//End if dict contains new_word
                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
        }//End While

        //BackTracking
        LinkedList<String> result = new LinkedList<String>();
        backTrace(end,start,result);

        return results;
    }
    private void backTrace(String word,String start,List<String> list){
        if (word.equals(start)){
            list.add(0,start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if (map.get(word)!=null)
            for (String s:map.get(word))
                backTrace(s,start,list);
        list.remove(0);
    }


}
