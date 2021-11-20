package main.FAANG.GraphUtils;

/*
On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.

A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.

Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone,
return the largest possible number of stones that can be removed.
*/

import java.util.HashSet;
import java.util.Set;

/*
We call a connected graph as an island.
One island must have at least one stone left.
The maximum stones can be removed = stones number - islands number
*/
public class MostStonesRemovedwithSameRoworColumn {
    public static void main(String[] args) {
        int[][] stones={{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        MostStonesRemovedwithSameRoworColumn m= new MostStonesRemovedwithSameRoworColumn();
        System.out.println(m.removeStones(stones));
    }

    int[] parent;

    int find(Integer x) {
        if(parent[x] == x )
            return x;
        return find(parent[x]);
    }

    int removeStones(int[][]  stones) {

        if (stones.length==0) return 0;
        int m = stones.length;

        parent=new int[m];
        for (int i = 0; i < m; i++)
            parent[i] = i;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    int x = find(i);
                    int y = find(j);
                    if (x != y)
                        parent[y] = x;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (parent[i] == i)
                ans++;
        }

        return m-ans;
    }


    /*
    DFS
    Time : O(N^2), N = # of stones
    Space: O(N)
    */

    public int removeStonesDFS(int[][] stones) {
        Set<int[]> visited = new HashSet();
        int numOfIslands = 0;
        for (int[] s1:stones){
            if (!visited.contains(s1)){
                dfs(s1, visited, stones);
                numOfIslands++;
            }
        }
        return stones.length - numOfIslands;
    }

    private void dfs(int[] s1, Set<int[]> visited, int[][] stones){
        visited.add(s1);
        for (int[] s2: stones){
            if (!visited.contains(s2)){
                // stone with same row or column. group them into island
                if (s1[0] == s2[0] || s1[1] == s2[1])
                    dfs(s2, visited, stones);
            }
        }
    }
}
