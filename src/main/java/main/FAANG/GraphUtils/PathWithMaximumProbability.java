package main.FAANG.GraphUtils;

import java.util.*;

public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();

        for(int i=0; i<edges.length; i++){
            map.putIfAbsent(edges[i][0], new HashMap<>());
            map.putIfAbsent(edges[i][1], new HashMap<>());
            map.get(edges[i][0]).put(edges[i][1], succProb[i]);
            map.get(edges[i][1]).put(edges[i][0], succProb[i]);
        }

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<double[]> queue = new PriorityQueue<double[]>((a, b) -> new Double(b[1]).compareTo(new Double(a[1])));
        queue.add(new double[]{start, 1.0});

        while(!queue.isEmpty()) {
            double[] cur = queue.poll();

            int curNode = (int)cur[0];
            double curWeight = cur[1];

            if(curNode == end) {
                return curWeight;
            }

            if(!visited.contains(curNode)) {
                visited.add(curNode);

                for(Map.Entry<Integer, Double> next: map.getOrDefault(curNode, new HashMap<>()).entrySet()) {
                    int nKey = next.getKey();
                    double nextWeight = next.getValue();

                    queue.add(new double[]{nKey, curWeight * nextWeight});
                }
            }
        }
        return 0;
    }

}
