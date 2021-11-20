package main.FAANG.HeapUtils;

import java.util.*;

public class RearrangeStringkDistanceApart {
    public String rearrangeString(String str, int k) {

        if(k == 0) return str;

        int len = str.length();
        Map<Character, Integer> counts = new HashMap<>();
        for(int i=0; i< len; i++){
            char ch = str.charAt(i);
            int n =1;
            if(counts.containsKey(ch)){
                n = counts.get(ch)+1;
            }
            counts.put(ch, n);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(10, (p1, p2) -> {
            if(p1.cnt != p2.cnt) return p2.cnt - p1.cnt;
            else return  p2.ch - p1.ch; // to ensure the order of the chars with same count, they should show up in same order.
        });

        for(Map.Entry<Character, Integer> entry : counts.entrySet()){
            pq.offer(new Pair(entry.getKey(), entry.getValue()));// pick the most show-up char first.
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            List<Pair> tmp = new ArrayList<>();// this is avoid you pick up same char in the same k-segment.
            int d = Math.min(k, len);
            for(int i=0; i< d; i++){
                if(pq.isEmpty()) return "";
                Pair p = pq.poll();
                sb.append(p.ch);
                if(--p.cnt > 0) tmp.add(p);
                len--;
            }
            for(Pair p : tmp) pq.offer(p);

        }

        return sb.toString();

    }

    class Pair{
        char ch;
        int cnt;
        Pair(char c, int t){
            ch = c;
            cnt = t;
        }
    };
}
