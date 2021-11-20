package main.FAANG.HeapUtils;

import java.util.*;

public class TaskScheduler {
//The idea used here is similar to - https://leetcode.com/problems/rearrange-string-k-distance-apart
//We need to arrange the characters in string such that each same character is K distance apart, where distance in this problems is time b/w two similar task execution.
//
//Idea is to add them to a priority Q and sort based on the highest frequency.
//And pick the task in each round of 'n' with highest frequency. As you pick the task, decrease the frequency, and put them back after the round.
    public static void main(String[] args) {
       // char[] tasks={'A','A','A','B','B','B','C','C','D'};
        char[] tasks={'A','A','A','B','B','B'};
        TaskScheduler taskScheduler=new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(tasks,2));
    }

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return -1;
        //build map to sum the amount of each task
        HashMap<Character,Integer> map = new HashMap<>();
        for (char ch:tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        // build queue, sort from descending
        PriorityQueue<Map.Entry<Character,Integer>> queue = new PriorityQueue<>((a, b)->(b.getValue()-a.getValue()));
        queue.addAll(map.entrySet());


        int cnt = 0;
        // when queue is not empty, there are remaining tasks
        while (!queue.isEmpty()){
            // for each interval
            int interval = n+1;
            // list used to update queue
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();

            // fill the intervals with the next high freq task
            while (interval > 0 && !queue.isEmpty()){
                Map.Entry<Character,Integer> entry = queue.poll();
                entry.setValue(entry.getValue()-1);
                list.add(entry);
                // interval shrinks
                interval --;
                // one slot is taken
                cnt ++;
            }

            // update the value in the map
            for (Map.Entry<Character,Integer> entry:list){
                // when there is left task
                if (entry.getValue() > 0)
                    queue.offer(entry);
            }
            // job done
            if (queue.isEmpty())
                break;
            // if interval is > 0, then the machine can only be idle
            cnt += interval;
        }

        return cnt;
    }

}
