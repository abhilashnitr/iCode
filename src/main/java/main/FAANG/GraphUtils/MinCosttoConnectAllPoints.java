package main.FAANG.GraphUtils;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCosttoConnectAllPoints {

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{0,0,0});

        Set<Integer> visited = new HashSet();

        int cost = 0;
        int len = points.length;

        while(!queue.isEmpty() && visited.size()<len) {
            int[] pq = queue.poll();
            int curNode = pq[0];
            int endNode = pq[1];
            int curCost = pq[2];

            if(visited.contains(endNode)) {
                continue;
            }
            cost = cost + curCost;

            visited.add(endNode);

            for(int i=0; i<len; i++) {
                if(!visited.contains(i)) {
                    queue.add(new int[]{endNode, i, distance(points, endNode, i)});
                }
            }
        }

        return cost;

    }

    private int distance(int[][] points, int i, int j) {
        return Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
