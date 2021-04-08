package main.FAANG.GraphUtils;

import java.util.*;

/*
In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
*/
public class RedundantConnection {

    //UnionFind
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        parent = new int[m + 1];
        for (int i = 0; i < m; i++) parent[i] = i;

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) return edge;
        }

        return new int[]{-1,-1};
    }

    private boolean union(int x, int y) {
        int p1 = find(x), p2 = find(y);
        if (p1 == p2) return false;
        parent[p1] = p2;
        return true;
    }

    private int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
            parent[x] = parent[parent[x]];
        }
        return x;
    }

    //DFS
    public int[] findRedundantConnectionDFS(int[][] edges) {
        int m = edges.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            if (dfs(new HashSet<>(), map, edge[0], edge[1])) return edge;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return new int[]{-1,-1};
    }

    private boolean dfs(Set<Integer> visited, Map<Integer, Set<Integer>> map,
                        int src, int target) {
        if (src == target) return true;
        visited.add(src);
        for (int next : map.get(src)) {
            if (!visited.contains(next)) {
                if (dfs(visited, map, next, target)) return true;
            }
        }
        return false;
    }

    //BFS
    public int[] findRedundantConnectionBFS(int[][] edges) {
        int m = edges.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            if (bfs(map, edge[0], edge[1])) return edge;
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        return new int[]{-1,-1};
    }

    private boolean bfs(Map<Integer, Set<Integer>> map,
                        int src, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        Set<Integer> visited = new HashSet<>();
        visited.add(src);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == target) return true;
            for (int next : map.get(cur)) {
                if (visited.add(next)) {
                    q.offer(next);
                }
            }
        }

        return false;
    }

    //Redundant Connection 2
    // same problem as above only diff is this is a directed graph


}
