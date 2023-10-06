package main.FAANG.GraphUtils;

import java.util.*;

//You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
//
//We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
public class NetworkDelayTime {

    //TC: O(E + Elog(E))
    //SC: O(V+E)
    public int networkDelayTime(int[][] times, int N, int K) {
        List<int[]>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] t : times) {
            adj[t[0] - 1].add(new int[]{t[1] - 1, t[2]});
        }

        int[] dist = new int[N];
        Arrays.fill(dist, -1);

        dist[K - 1] = 0;
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.offer(new int[]{K - 1, 0});

        while (minHeap.size() > 0) {
            int curr = minHeap.peek()[0];
            minHeap.poll();
            for (int[] pair : adj[curr]) {
                int next = pair[0];
                int weight = pair[1];
                int d = dist[curr] + weight;
                if (dist[next] == -1 || dist[next] > d) {
                    dist[next] = d;
                    minHeap.offer(new int[]{next, dist[next]});
                }
            }
        }

        int maxwait = 0;
        for (int i = 0; i < N; i++) {
            if(dist[i] == -1)
                return -1;
            maxwait = Math.max(maxwait, dist[i]);
        }
        return maxwait;
    }

}
