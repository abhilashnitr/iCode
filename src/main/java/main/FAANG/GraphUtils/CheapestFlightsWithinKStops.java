package main.FAANG.GraphUtils;

import java.util.*;

//There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
//You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1
public class CheapestFlightsWithinKStops {

    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    class Tuple {
        int first, second, third;
        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    class Solution {
        public int findCheapestPrice(int n,int flights[][],int src,int dst,int K) {

            // Create the adjacency list to depict airports and flights in
            // the form of a graph.
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for(int i = 0;i<n;i++) {
                adj.add(new ArrayList<>());
            }
            int m = flights.length;
            for(int i = 0;i<m;i++) {
                adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
            }

            // Create a queue which stores the node and their distances from the
            // source in the form of {stops, {node, dist}} with ‘stops’ indicating
            // the no. of nodes between src and current node.
            Queue<Tuple> q = new LinkedList<>();

            q.add(new Tuple(0, src, 0));

            // Distance array to store the updated distances from the source.
            int[] dist = new int[n];
            for(int i = 0;i<n;i++) {
                dist[i] = (int)(1e9);
            }
            dist[src] = 0;

            // Iterate through the graph using a queue like in Dijkstra with
            // popping out the element with min stops first.
            while(!q.isEmpty()) {
                Tuple it = q.peek();
                q.remove();
                int stops = it.first;
                int node = it.second;
                int cost = it.third;

                // We stop the process as soon as the limit for the stops reaches.
                if(stops > K) continue;
                for(Pair iter: adj.get(node)) {
                    int adjNode = iter.first;
                    int edW = iter.second;

                    // We only update the queue if the new calculated dist is
                    // less than the prev and the stops are also within limits.
                    if (cost + edW < dist[adjNode] && stops <= K) {
                        dist[adjNode] = cost + edW;
                        q.add(new Tuple(stops + 1, adjNode, cost + edW));
                    }
                }
            }
            // If the destination node is unreachable return ‘-1’
            // else return the calculated dist from src to dst.
            if(dist[dst] == (int)(1e9)) return -1;
            return dist[dst];
        }
    }

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                for (int[] neighbour : adj.get(curr[0])) {
                    int price = neighbour[1], neighbourNode = neighbour[0];
                    if (price + curr[1] >= minCost[neighbourNode]) continue;
                    minCost[neighbourNode] = price + curr[1];
                    q.offer(new int[] {neighbourNode, minCost[neighbourNode]});
                }
            }
            stops++;
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }


    //Time Complexity and Space Complexity
    //Time complexity: O(V + E*K)
    //The time complexity of this code is O(V + E*K) where E is the number of flights, and V is the number of cities. The reason for this is that the outer while loop runs for at most V iterations, and in each iteration, the inner while loop runs for at most E iterations.However, the maximum number of times an edge can be processed is limited by K.
    //Space complexity: O(V + E)
    //he space complexity of this code is O(V + E), as it uses two data structures to store the graph (a list of lists) and the minimum cost to reach each node (an array of integers). The queue used to keep track of the next node to visit also takes up O(V) space.

}
